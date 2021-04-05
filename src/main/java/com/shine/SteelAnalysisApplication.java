package com.shine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.shine.mapper")
@SpringBootApplication
public class SteelAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SteelAnalysisApplication.class, args);
    }

}
