package com.shine.model.vo;

import lombok.Data;

@Data
public class StockVO {
    private Integer id;
    private String product;
    private Integer amount;
    private String region;
}
