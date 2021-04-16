package com.shine.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shine.mapper.MyOrderMapper;
import com.shine.mapper.MyStockMapper;
import com.shine.mapper.OrderMapper;
import com.shine.mapper.StockMapper;
import com.shine.model.Order;

import com.shine.model.vo.OrderView;
import com.shine.model.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MyStockMapper myStockMapper;
    @Autowired
    private MyOrderMapper myOrderMapper;

    public Result getPage(int page,int limit){
        PageHelper.startPage(page,limit);
        List<OrderView> list = myOrderMapper.findAll();
        PageInfo info = new PageInfo(list);
        return Result.success(list,info.getTotal());
    }

    public Result add(Order order){
        int row = orderMapper.insertSelective(order);
        if(row==1) myStockMapper.updateAmount(order.getPid(),order.getRid(),-order.getAmount());
        return Result.ok();
    }
}
