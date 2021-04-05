package com.shine.mapper;

import com.shine.model.sale;
import com.shine.model.saleExample.Criteria;
import com.shine.model.saleExample.Criterion;
import com.shine.model.saleExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class saleSqlProvider {
    public String countByExample(saleExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_sale");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(saleExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_sale");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(sale record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_sale");
        
        if (record.getPid() != null) {
            sql.VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getArea() != null) {
            sql.VALUES("area", "#{area,jdbcType=VARCHAR}");
        }
        
        if (record.getSaled() != null) {
            sql.VALUES("saled", "#{saled,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.VALUES("stock", "#{stock,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(saleExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("pid");
        sql.SELECT("area");
        sql.SELECT("saled");
        sql.SELECT("stock");
        sql.FROM("t_sale");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        sale record = (sale) parameter.get("record");
        saleExample example = (saleExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_sale");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{record.pid,jdbcType=INTEGER}");
        }
        
        if (record.getArea() != null) {
            sql.SET("area = #{record.area,jdbcType=VARCHAR}");
        }
        
        if (record.getSaled() != null) {
            sql.SET("saled = #{record.saled,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_sale");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("pid = #{record.pid,jdbcType=INTEGER}");
        sql.SET("area = #{record.area,jdbcType=VARCHAR}");
        sql.SET("saled = #{record.saled,jdbcType=INTEGER}");
        sql.SET("stock = #{record.stock,jdbcType=INTEGER}");
        
        saleExample example = (saleExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(sale record) {
        SQL sql = new SQL();
        sql.UPDATE("t_sale");
        
        if (record.getPid() != null) {
            sql.SET("pid = #{pid,jdbcType=INTEGER}");
        }
        
        if (record.getArea() != null) {
            sql.SET("area = #{area,jdbcType=VARCHAR}");
        }
        
        if (record.getSaled() != null) {
            sql.SET("saled = #{saled,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{stock,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, saleExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}