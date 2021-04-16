package com.shine.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shine.mapper.MyStockMapper;
import com.shine.mapper.StockMapper;
import com.shine.model.Stock;
import com.shine.model.vo.Result;
import com.shine.model.vo.StockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockMapper mapper;
    @Autowired
    private MyStockMapper myStockMapper;

    public  Result getPage(int page,int limit){
        PageHelper.startPage(page,limit);
        List<StockVO> list = myStockMapper.findAll();
        PageInfo info = new PageInfo(list);
        return Result.success(list,info.getTotal());
    }

    public Result add(int pid, int amount, byte regionId){
        Stock stock = new Stock()
                .withPid(pid)
                .withAmount(amount)
                .withRegionId(regionId);
        mapper.insertSelective(stock);
        return Result.ok();
    }

    public Result update(int id, int amount){
        Stock stock = new Stock();
        stock.withId(id).withAmount(amount);
        mapper.updateByPrimaryKeySelective(stock);
        return Result.ok();
    }
}
