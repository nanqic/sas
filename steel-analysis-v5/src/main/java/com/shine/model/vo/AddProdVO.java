package com.shine.model.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AddProdVO {
    private MultipartFile file;
    private Integer pid;
    private String name;
    private int price;
    private byte sortId;
    private String describe;
}
