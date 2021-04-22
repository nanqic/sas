package com.shine.mapper;

import com.shine.model.Sort;
import com.shine.model.SortExample;
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

public interface SortMapper {
    @SelectProvider(type=SortSqlProvider.class, method="countByExample")
    long countByExample(SortExample example);

    @DeleteProvider(type=SortSqlProvider.class, method="deleteByExample")
    int deleteByExample(SortExample example);

    @Delete({
        "delete from t_sort",
        "where sid = #{sid,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte sid);

    @Insert({
        "insert into t_sort (name)",
        "values (#{name,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="sid")
    int insert(Sort record);

    @InsertProvider(type=SortSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="sid")
    int insertSelective(Sort record);

    @SelectProvider(type=SortSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="sid", property="sid", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Sort> selectByExample(SortExample example);

    @Select({
        "select",
        "sid, name",
        "from t_sort",
        "where sid = #{sid,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="sid", property="sid", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Sort selectByPrimaryKey(Byte sid);

    @UpdateProvider(type=SortSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Sort record, @Param("example") SortExample example);

    @UpdateProvider(type=SortSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Sort record, @Param("example") SortExample example);

    @UpdateProvider(type=SortSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sort record);

    @Update({
        "update t_sort",
        "set name = #{name,jdbcType=VARCHAR}",
        "where sid = #{sid,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(Sort record);
}