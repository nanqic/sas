package com.shine.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderView {
    private Integer id;
    private String username;
    private String product;
    private String img;
    private Integer amount;
    private String region;
    private String remark;
    private Date orderTime;
    private Byte status;
}
