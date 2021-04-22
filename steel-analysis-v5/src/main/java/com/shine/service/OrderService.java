package com.shine.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shine.mapper.*;
import com.shine.model.Order;

import com.shine.model.Sale;
import com.shine.model.Stock;
import com.shine.model.vo.CodeMsg;
import com.shine.model.vo.OrderView;
import com.shine.model.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MyStockMapper myStockMapper;
    @Autowired
    private MyOrderMapper myOrderMapper;
    @Autowired
    private MySaleMapper mySaleMapper;

    public Result getPage(int page, int limit) {
        if(limit!=0)PageHelper.startPage(page, limit);
        List<OrderView> list = myOrderMapper.findAll("v_order");
        PageInfo info = new PageInfo(list);
        return Result.success(list, info.getTotal());
    }

    public Result getHistoryPage(int page, int limit) {
        if(limit!=0)PageHelper.startPage(page, limit);
        List<OrderView> list = myOrderMapper.findAll("v_order_history");
        PageInfo info = new PageInfo(list);
        return Result.success(list, info.getTotal());
    }


    public Result add(Order order) {
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        order.setOrderTime(sqlDate);
        int row = orderMapper.insertSelective(order);
        if (row == 1) {
            int row2 = myStockMapper.updateAmount(order.getPid(), order.getRid(), -order.getAmount());
            if (row2 == 1) return Result.ok();
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    public Result cancel(int id) {
        Order oldOrder = orderMapper.selectByPrimaryKey(id);
        mySaleMapper.insertOrUpdate(oldOrder.getPid(), oldOrder.getRid(), -oldOrder.getAmount());
        myStockMapper.updateAmount(oldOrder.getPid(), oldOrder.getRid(), +oldOrder.getAmount());
        Byte status = 0;
        Order order = new Order().withId(id).withStatus(status);
        orderMapper.updateByPrimaryKeySelective(order);
        return Result.ok();
    }

    public Result complete(int id) {

        Byte status = 2;
        Order order = new Order().withId(id).withStatus(status);
        int row = orderMapper.updateByPrimaryKeySelective(order);
        if (row == 1) {
            int row2 = myOrderMapper.updateExp(id);
            if (row2 == 1) {
                Order order1  = orderMapper.selectByPrimaryKey(id);
                int row3 = mySaleMapper.insertOrUpdate(order1.getPid(), order1.getRid(), order1.getAmount());
                if(row3==1)        return Result.ok();
            }
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }
}
