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

    @Select("SELECT `t_region`.`name`, sum( `t_sale`.`sold_amount` ) AS `amount` FROM ( `t_sale` JOIN `t_region` ON (( `t_region`.`rid` = `t_sale`.`rid` ))) \n" +
            "WHERE\n" +
            "\t`t_sale`.`pid` IN (\n" +
            "\tSELECT\n" +
            "\t\t`t_product`.`pid` \n" +
            "\tFROM\n" +
            "\t\t`t_product` \n" +
            "\tWHERE\n" +
            "\t( `t_product`.`sort_id` = #{sid} AND t_sale.update_time BETWEEN #{startTime} AND #{endTime} )) \n" +
            "GROUP BY\n" +
            "\t`t_region`.`name`")
    AnalysisVO[] getAnaBySid(Byte sid, String startTime, String endTime);

    /**
     *
     * @param rid 地区id
     * @param startTime 订单的开始时间
     * @param endTime 结束时间
     * @return
     *
    */
    @Select("SELECT st.`name`,rid,SUM(o.amount) AS amount FROM t_order o JOIN t_product p ON o.pid=p.pid JOIN t_sort st ON p.sort_id=st.sid  WHERE o.`status`=2 AND rid=#{rid} AND o.order_time BETWEEN #{startTime} AND #{endTime} GROUP BY `name`")
    AnalysisVO[] getAnaByRegion(Byte rid, String startTime, String endTime);
}
