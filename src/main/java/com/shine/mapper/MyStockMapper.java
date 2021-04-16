package com.shine.mapper;

import com.shine.model.vo.StockVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyStockMapper {
    @Select("select s.id, p.name as product, s.amount,r.name as region from (t_product p JOIN t_stock s ON p.id=s.pid) JOIN t_region r ON s.region_id=r.id")
    List<StockVO> findAll();
}
