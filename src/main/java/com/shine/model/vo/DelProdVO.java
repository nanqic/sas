package com.shine.model.vo;

import lombok.Data;

import java.util.List;

/**
 * 批量删除商品视图
 */

@Data
public class DelProdVO {
    private List<Integer> ids;
    private String[] paths;
}
