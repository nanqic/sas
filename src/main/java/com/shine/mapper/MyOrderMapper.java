package com.shine.mapper;

import com.shine.model.vo.OrderView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MyOrderMapper {
    @Select("select *from ${order}")
    List<OrderView> findAll(String order);

    @Update("UPDATE t_user INNER JOIN(SELECT o.uid,o.amount, p.price FROM t_order o JOIN t_product p ON o.pid=p.pid WHERE o.id=#{id}) t_order ON t_order.uid=t_user.uid SET t_user.experience=CEILING((amount*price/10))")
    int updateExp(int id);
}
