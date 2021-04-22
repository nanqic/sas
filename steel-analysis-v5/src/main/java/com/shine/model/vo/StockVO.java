package com.shine.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class StockVO {
    private Integer id;
    private String product;
    private Integer amount;
    private String region;
    private Date updateTime;
}
