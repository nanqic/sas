package com.shine.mapper;

import com.shine.model.SystemMenu;
import com.shine.model.SystemMenuExample;
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

public interface SystemMenuMapper {
    @SelectProvider(type=SystemMenuSqlProvider.class, method="countByExample")
    long countByExample(SystemMenuExample example);

    @DeleteProvider(type=SystemMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemMenuExample example);

    @Delete({
        "delete from t_system_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_system_menu (pid, title, ",
        "icon, href, target, ",
        "sort, status, remark, ",
        "create_at, update_at, ",
        "delete_at)",
        "values (#{pid,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{icon,jdbcType=VARCHAR}, #{href,jdbcType=VARCHAR}, #{target,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=INTEGER}, #{status,jdbcType=TINYINT}, #{remark,jdbcType=VARCHAR}, ",
        "#{createAt,jdbcType=TIMESTAMP}, #{updateAt,jdbcType=TIMESTAMP}, ",
        "#{deleteAt,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemMenu record);

    @InsertProvider(type=SystemMenuSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemMenu record);

    @SelectProvider(type=SystemMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="href", property="href", jdbcType=JdbcType.VARCHAR),
        @Result(column="target", property="target", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_at", property="deleteAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SystemMenu> selectByExample(SystemMenuExample example);

    @Select({
        "select",
        "id, pid, title, icon, href, target, sort, status, remark, create_at, update_at, ",
        "delete_at",
        "from t_system_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="href", property="href", jdbcType=JdbcType.VARCHAR),
        @Result(column="target", property="target", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="delete_at", property="deleteAt", jdbcType=JdbcType.TIMESTAMP)
    })
    SystemMenu selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemMenu record, @Param("example") SystemMenuExample example);

    @UpdateProvider(type=SystemMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemMenu record, @Param("example") SystemMenuExample example);

    @UpdateProvider(type=SystemMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemMenu record);

    @Update({
        "update t_system_menu",
        "set pid = #{pid,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "href = #{href,jdbcType=VARCHAR},",
          "target = #{target,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "update_at = #{updateAt,jdbcType=TIMESTAMP},",
          "delete_at = #{deleteAt,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemMenu record);
}