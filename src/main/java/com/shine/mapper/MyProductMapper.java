package com.shine.mapper;

import com.shine.model.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyProductMapper {
    @Select("select p.*,s.name as sort from t_product p left join t_sort s on p.sort_id=s.sid")
    List<ProductVO> findAll();
}
