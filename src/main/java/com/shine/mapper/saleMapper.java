package com.shine.mapper;

import com.shine.model.sale;
import com.shine.model.saleExample;
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

public interface saleMapper {
    @SelectProvider(type=saleSqlProvider.class, method="countByExample")
    long countByExample(saleExample example);

    @DeleteProvider(type=saleSqlProvider.class, method="deleteByExample")
    int deleteByExample(saleExample example);

    @Delete({
        "delete from t_sale",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_sale (pid, province, ",
        "sold, stock)",
        "values (#{pid,jdbcType=INTEGER}, #{province,jdbcType=VARCHAR}, ",
        "#{sold,jdbcType=INTEGER}, #{stock,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(sale record);

    @InsertProvider(type=saleSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(sale record);

    @SelectProvider(type=saleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="sold", property="sold", jdbcType=JdbcType.INTEGER),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER)
    })
    List<sale> selectByExample(saleExample example);

    @Select({
        "select",
        "id, pid, province, sold, stock",
        "from t_sale",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="sold", property="sold", jdbcType=JdbcType.INTEGER),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER)
    })
    sale selectByPrimaryKey(Integer id);

    @UpdateProvider(type=saleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") sale record, @Param("example") saleExample example);

    @UpdateProvider(type=saleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") sale record, @Param("example") saleExample example);

    @UpdateProvider(type=saleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(sale record);

    @Update({
        "update t_sale",
        "set pid = #{pid,jdbcType=INTEGER},",
          "province = #{province,jdbcType=VARCHAR},",
          "sold = #{sold,jdbcType=INTEGER},",
          "stock = #{stock,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(sale record);
}