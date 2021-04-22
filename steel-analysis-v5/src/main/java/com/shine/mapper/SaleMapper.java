package com.shine.mapper;

import com.shine.model.Sale;
import com.shine.model.SaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SaleMapper {
    @SelectProvider(type=SaleSqlProvider.class, method="countByExample")
    long countByExample(SaleExample example);

    @DeleteProvider(type=SaleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SaleExample example);

    @Delete({
        "delete from t_sale",
        "where pid = #{pid,jdbcType=INTEGER}",
          "and rid = #{rid,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(@Param("pid") Integer pid, @Param("rid") Byte rid);

    @Insert({
        "insert into t_sale (pid, rid, ",
        "sold_amount, update_time)",
        "values (#{pid,jdbcType=INTEGER}, #{rid,jdbcType=TINYINT}, ",
        "#{soldAmount,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Sale record);

    @InsertProvider(type=SaleSqlProvider.class, method="insertSelective")
    int insertSelective(Sale record);

    @SelectProvider(type=SaleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rid", property="rid", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="sold_amount", property="soldAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Sale> selectByExample(SaleExample example);

    @Select({
        "select",
        "pid, rid, sold_amount, update_time",
        "from t_sale",
        "where pid = #{pid,jdbcType=INTEGER}",
          "and rid = #{rid,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rid", property="rid", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="sold_amount", property="soldAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Sale selectByPrimaryKey(@Param("pid") Integer pid, @Param("rid") Byte rid);

    @UpdateProvider(type=SaleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Sale record, @Param("example") SaleExample example);

    @UpdateProvider(type=SaleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Sale record, @Param("example") SaleExample example);

    @UpdateProvider(type=SaleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sale record);

    @Update({
        "update t_sale",
        "set sold_amount = #{soldAmount,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where pid = #{pid,jdbcType=INTEGER}",
          "and rid = #{rid,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(Sale record);
}