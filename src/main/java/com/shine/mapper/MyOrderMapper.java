package com.shine.mapper;

import com.shine.model.vo.OrderView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyOrderMapper {
    @Select("select *from v_order")
    List<OrderView> findAll();
}