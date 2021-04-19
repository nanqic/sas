package com.shine.mapper;

import com.shine.model.Stock;
import com.shine.model.vo.StockVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MyStockMapper {
    @Select("select s.id, p.name as product, s.amount,r.name as region ,s.update_time from (t_product p JOIN t_stock s ON p.pid=s.pid) JOIN t_region r ON s.rid=r.rid")
    List<StockVO> findAll();

    @Select("SELECT rid,amount FROM t_stock WHERE pid=#{pid}")
    List<Stock> findByPid(int pid);

    @Update("UPDATE t_stock SET amount=amount+#{amount} WHERE pid=#{pid} and rid=#{rid}")
    int updateAmount(int pid, byte rid, int amount);
}
