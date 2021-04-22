package com.shine.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shine.mapper.RegionMapper;
import com.shine.mapper.SortMapper;
import com.shine.mapper.StockMapper;
import com.shine.model.*;
import com.shine.model.vo.CodeMsg;
import com.shine.model.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    RegionMapper mapper;
    @Autowired
    StockMapper stockMapper;

    public Result add(String name){
        mapper.insertSelective(new Region().withName(name));
        return Result.ok();
    }
    public Result deleteOne(byte rid){
        StockExample example = new StockExample();
        example.createCriteria().andRidEqualTo(rid);
        Long count =  stockMapper.countByExample(example);
        if (count>0)return Result.error(CodeMsg.DELETE_ERROR);
        mapper.deleteByPrimaryKey(rid);
        return Result.ok();
    }
    public Result updateOne(Region region){
        mapper.updateByPrimaryKey(region);
        return Result.ok();
    }
    public Result findAll(int page,int limit){
        RegionExample example = new RegionExample();
        example.createCriteria().getAllCriteria();
        if(limit!=0) PageHelper.startPage(page,limit);
        List<Region> list = mapper.selectByExample(example);
        PageInfo info = new PageInfo(list);
        return Result.success(list,info.getTotal());
    }
}
