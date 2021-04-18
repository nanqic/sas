package com.shine.mapper;

import com.shine.model.Product;
import com.shine.model.ProductExample;
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

public interface ProductMapper {
    @SelectProvider(type=ProductSqlProvider.class, method="countByExample")
    long countByExample(ProductExample example);

    @DeleteProvider(type=ProductSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductExample example);

    @Delete({
        "delete from t_product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_product (name, price, ",
        "sort_id, img, describes, ",
        "on_sale, added_time)",
        "values (#{name,jdbcType=VARCHAR}, #{price,jdbcType=INTEGER}, ",
        "#{sortId,jdbcType=TINYINT}, #{img,jdbcType=VARCHAR}, #{describes,jdbcType=VARCHAR}, ",
        "#{onSale,jdbcType=BIT}, #{addedTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(Product record);

    @InsertProvider(type=ProductSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(Product record);

    @SelectProvider(type=ProductSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="sort_id", property="sortId", jdbcType=JdbcType.TINYINT),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="describes", property="describes", jdbcType=JdbcType.VARCHAR),
        @Result(column="on_sale", property="onSale", jdbcType=JdbcType.BIT),
        @Result(column="added_time", property="addedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Product> selectByExample(ProductExample example);

    @Select({
        "select",
        "id, name, price, sort_id, img, describes, on_sale, added_time",
        "from t_product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="sort_id", property="sortId", jdbcType=JdbcType.TINYINT),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="describes", property="describes", jdbcType=JdbcType.VARCHAR),
        @Result(column="on_sale", property="onSale", jdbcType=JdbcType.BIT),
        @Result(column="added_time", property="addedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Product selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update t_product",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=INTEGER},",
          "sort_id = #{sortId,jdbcType=TINYINT},",
          "img = #{img,jdbcType=VARCHAR},",
          "describes = #{describes,jdbcType=VARCHAR},",
          "on_sale = #{onSale,jdbcType=BIT},",
          "added_time = #{addedTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Product record);
}