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

    /**
     *
     * @param sid 分类id
     * @param startTime 下单时间
     * @param endTime 结束时间
     * @return AnalysisVO[] 返回名称和数量结果集
     */
    @Select("SELECT r.name, SUM(o.amount) as amount FROM t_order o JOIN t_product p ON o.pid=p.pid JOIN t_region r ON r.rid=o.rid WHERE o.`status`= 2 AND  p.pid IN (SELECT pid FROM t_product WHERE sort_id = #{sid}) AND o.order_time BETWEEN #{startTime} AND #{endTime} GROUP BY r.`name`")
    AnalysisVO[] getAnaBySid(Byte sid, String startTime, String endTime);

    /**
     *
     * @param rid 地区id
     * @param startTime 订单的开始时间
     * @param endTime 结束时间
     * @return AnalysisVO[] 返回名称和数量结果集
     *
    */
    @Select("SELECT st.`name`,SUM(o.amount) AS amount FROM t_order o JOIN t_product p ON o.pid=p.pid JOIN t_sort st ON p.sort_id=st.sid  WHERE o.`status`=2 AND rid=#{rid} AND o.order_time BETWEEN #{startTime} AND #{endTime} GROUP BY `name`")
    AnalysisVO[] getAnaByRegion(Byte rid, String startTime, String endTime);
}
