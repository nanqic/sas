package com.shine.mapper;

import com.shine.model.vo.AnalysisVO;
import com.shine.model.vo.SaleView;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface MySaleMapper {
    @Select("select *from v_sale")
    List<SaleView> findAll();

    @Insert("INSERT INTO t_sale(pid,rid,sold_amount) VALUES(#{pid},#{rid},#{soldAmount}) ON DUPLICATE KEY UPDATE sold_amount=sold_amount+VALUES(sold_amount)")
    int insertOrUpdate(int pid, int rid, int soldAmount);

    @Select("SELECT `t_region`.`name`, sum( `t_sale`.`sold_amount` ) AS `amount` FROM ( `t_sale` JOIN `t_region` ON (( `t_region`.`id` = `t_sale`.`rid` ))) \n" +
            "WHERE\n" +
            "\t`t_sale`.`pid` IN (\n" +
            "\tSELECT\n" +
            "\t\t`t_product`.`id` \n" +
            "\tFROM\n" +
            "\t\t`t_product` \n" +
            "\tWHERE\n" +
            "\t( `t_product`.`sort_id` = #{sid} AND t_sale.update_time BETWEEN #{startTime} AND #{endTime} )) \n" +
            "GROUP BY\n" +
            "\t`t_region`.`name`")
    AnalysisVO[] getAnaBySid(Byte sid, String startTime, String endTime);

    @Select("\n" +
            "SELECT\n" +
            "\t`t_sort`.`name` AS `name`,\n" +
            "\tSUM(`t_sale`.`sold_amount`) AS `amount`\n" +
            "FROM\n" +
            "\t((\n" +
            "\t\t\t`t_sort`\n" +
            "\t\t\tJOIN `t_product` `p` ON ((\n" +
            "\t\t\t\t\t`t_sort`.`id` = `p`.`sort_id` \n" +
            "\t\t\t\t)))\n" +
            "\t\tJOIN `t_sale` ON ((\n" +
            "\t\t\t\t`p`.`id` = `t_sale`.`pid` \n" +
            "\t\t\t))) \n" +
            "WHERE\n" +
            "\t((\n" +
            "\t\t\t`t_sale`.`rid` = 1 \n" +
            "\t\t\t) \n" +
            "\t\tAND `p`.`id` IN (\n" +
            "\t\tSELECT\n" +
            "\t\t\t`t_sale`.`pid` \n" +
            "\t\tFROM\n" +
            "\t\t\t`t_sale` \n" +
            "\tWHERE\n" +
            "\t( `t_sale`.`rid` = #{rid} )))\n" +
            "AND update_time BETWEEN #{startTime} AND #{endTime}" +
            "GROUP BY t_sort.`name`")
    AnalysisVO[] getAnaByRegion(Byte rid, String startTime, String endTime);
}
