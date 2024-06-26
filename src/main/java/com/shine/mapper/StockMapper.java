package com.shine.mapper;

import com.shine.model.Stock;
import com.shine.model.StockExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface StockMapper {
    @SelectProvider(type=StockSqlProvider.class, method="countByExample")
    long countByExample(StockExample example);

    @DeleteProvider(type=StockSqlProvider.class, method="deleteByExample")
    int deleteByExample(StockExample example);

    @Delete({
        "delete from t_stock",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_stock (pid, amount, ",
        "rid, update_time)",
        "values (#{pid,jdbcType=INTEGER}, #{amount,jdbcType=INTEGER}, ",
        "#{rid,jdbcType=TINYINT}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(Stock record);

    @InsertProvider(type=StockSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(Stock record);

    @SelectProvider(type=StockSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="rid", property="rid", jdbcType=JdbcType.TINYINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Stock> selectByExample(StockExample example);

    @Select({
        "select",
        "id, pid, amount, rid, update_time",
        "from t_stock",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="rid", property="rid", jdbcType=JdbcType.TINYINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Stock selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StockSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    @UpdateProvider(type=StockSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    @UpdateProvider(type=StockSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Stock record);

    @Update({
        "update t_stock",
        "set pid = #{pid,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=INTEGER},",
          "rid = #{rid,jdbcType=TINYINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Stock record);
}