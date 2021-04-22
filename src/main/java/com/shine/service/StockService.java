package com.shine.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shine.mapper.MyStockMapper;
import com.shine.mapper.StockMapper;
import com.shine.model.Stock;
import com.shine.model.StockExample;
import com.shine.model.vo.RegionStockVO;
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

    public Result getPage(int page, int limit) {
        if(limit!=0)PageHelper.startPage(page, limit);
        List<StockVO> list = myStockMapper.findAll();
        PageInfo info = new PageInfo(list);
        return Result.success(list, info.getTotal());
    }

    public Result add(int pid, int amount, byte rid) {
        Stock stock = new Stock()
                .withPid(pid)
                .withAmount(amount)
                .withRid(rid);
        StockExample example = new StockExample();
        example.createCriteria().andPidEqualTo(pid).andRidEqualTo(rid);
        List<Stock> list = mapper.selectByExample(example);
        if (list.isEmpty()){
            mapper.insertSelective(stock);
        }else {
            Stock existStock = list.get(0);
            stock.withId(existStock.getId());
            stock.withAmount(amount+existStock.getAmount());
            mapper.updateByPrimaryKeySelective(stock);
        }
        return Result.ok();
    }

    public Result update(int id, int amount) {
        Stock stock = new Stock();
        stock.withId(id).withAmount(amount);
        mapper.updateByPrimaryKeySelective(stock);
        return Result.ok();
    }

    public Result getAmount(int pid) {
        List<RegionStockVO> list = myStockMapper.findByPid(pid);
        return Result.success(list, 0);
    }
}
