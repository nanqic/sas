package com.shine.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ProductVO {
    private Integer pid;

    private String name;

    private Integer price;

    private String sort;

    private Integer sortId;

    private String img;

    private String describes;

    private Boolean onSale;

    private Date addedTime;
}
