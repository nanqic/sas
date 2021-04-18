package com.shine.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SaleView {
    private String product;
    private String region;
    private Integer soldAmount;
    private Date updateTime;
}
