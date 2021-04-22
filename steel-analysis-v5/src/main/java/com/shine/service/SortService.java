package com.shine.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shine.mapper.ProductMapper;
import com.shine.mapper.SortMapper;
import com.shine.model.ProductExample;
import com.shine.model.Sort;
import com.shine.model.SortExample;
import com.shine.model.vo.CodeMsg;
import com.shine.model.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {
    @Autowired
    SortMapper mapper;
    @Autowired
    ProductMapper productMapper;

    public Result add(String name){
        mapper.insertSelective(new Sort().withName(name));
        return Result.ok();
    }

    public Result deleteOne(byte sid){
        ProductExample example = new ProductExample();
        example.createCriteria().andSortIdEqualTo(sid);
        Long count =  productMapper.countByExample(example);
        if (count>0)return Result.error(CodeMsg.DELETE_ERROR);

        mapper.deleteByPrimaryKey(sid);
        return Result.ok();
    }

    public Result updateOne(Sort sort){
        mapper.updateByPrimaryKey(sort);
        return Result.ok();
    }
    public Result findAll(int page,int limit){
        SortExample example = new SortExample();
        example.createCriteria().getAllCriteria();
        if(limit!=0)PageHelper.startPage(page,limit);
        List<Sort> list = mapper.selectByExample(example);
        PageInfo info = new PageInfo(list);
        return Result.success(list,info.getTotal());
    }
}
