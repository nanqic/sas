package com.shine.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shine.mapper.MyProductMapper;
import com.shine.mapper.ProductMapper;
import com.shine.model.Product;
import com.shine.model.ProductExample;
import com.shine.model.vo.CodeMsg;
import com.shine.model.vo.DelProdVO;
import com.shine.model.vo.ProductVO;
import com.shine.model.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductMapper mapper;
    @Autowired
    MyProductMapper myProductMapper;
    @Value("${upload-path}")
    private String filePath;

    public Result add(Product product, MultipartFile img) throws IOException {
        // 存储文件
        String newFileName = writeFile(img);
        product.withImg(newFileName);

        Date utilDate  = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        product.withAddedTime(sqlDate);
        int row = mapper.insertSelective(product);
        if (row == 1) return Result.ok();
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    public Result getPage(int page, int size) {
        if (size!=0) PageHelper.startPage(page, size);
        List<ProductVO> list = myProductMapper.findAll();
        PageInfo info = new PageInfo(list);

        return Result.success(list, info.getTotal());
    }

    public Result delete(int id, String path) {
        mapper.deleteByPrimaryKey(id);
        File file = new File(filePath + path);
        deleteFile(file);
        return Result.ok();
    }

    public Result update(Product product, MultipartFile... file) throws IOException {

        if (file[0]!=null) {
            String newFileName = writeFile(file[0]);
            product.withImg(newFileName);
            String oldImg = mapper.selectByPrimaryKey(product.getPid()).getImg();
            File imgFile = new File(filePath + oldImg);
            deleteFile(imgFile);
        }

        mapper.updateByPrimaryKeySelective(product);

        return Result.ok();
    }

    public Result deleteList(DelProdVO vo) {
        List<Integer> ids = vo.getIds();
        String[] paths = vo.getPaths();
        // 删除数据
        ProductExample example = new ProductExample();
        example.createCriteria()
                .andPidIn(ids);
        mapper.deleteByExample(example);
        // 删除文件
        for (String path : paths) {
            deleteFile(new File(filePath + path));
        }
        return Result.ok();
    }

    public Result switchOnSale(int pid, Boolean onSale) {
        Product product = new Product()
                .withPid(pid).withOnSale(onSale);
        mapper.updateByPrimaryKeySelective(product);
        return Result.ok();
    }

    private String writeFile(MultipartFile img) throws IOException {
        File dir = new File(filePath);
        if (!dir.isDirectory())
            dir.mkdir();
        String fileOriginalName = img.getOriginalFilename();
        String newFileName = UUID.randomUUID() + fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
        File writeFile = new File(filePath + newFileName);
        //文件写入磁盘
        img.transferTo(writeFile);

        return newFileName;
    }

    private void deleteFile(File file) {
        boolean exis = file.exists();     // 判断目录或文件是否存在
        boolean isex = file.isFile();     // 判断是否为文件
        if (exis && isex) file.delete();  //删除文件
    }
}
