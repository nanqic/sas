package com.shine.mapper;

import com.shine.model.Region;
import com.shine.model.RegionExample;
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

public interface RegionMapper {
    @SelectProvider(type=RegionSqlProvider.class, method="countByExample")
    long countByExample(RegionExample example);

    @DeleteProvider(type=RegionSqlProvider.class, method="deleteByExample")
    int deleteByExample(RegionExample example);

    @Delete({
        "delete from t_region",
        "where rid = #{rid,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte rid);

    @Insert({
        "insert into t_region (name)",
        "values (#{name,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="rid")
    int insert(Region record);

    @InsertProvider(type=RegionSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="rid")
    int insertSelective(Region record);

    @SelectProvider(type=RegionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="rid", property="rid", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Region> selectByExample(RegionExample example);

    @Select({
        "select",
        "rid, name",
        "from t_region",
        "where rid = #{rid,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="rid", property="rid", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Region selectByPrimaryKey(Byte rid);

    @UpdateProvider(type=RegionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Region record, @Param("example") RegionExample example);

    @UpdateProvider(type=RegionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Region record, @Param("example") RegionExample example);

    @UpdateProvider(type=RegionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Region record);

    @Update({
        "update t_region",
        "set name = #{name,jdbcType=VARCHAR}",
        "where rid = #{rid,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(Region record);
}