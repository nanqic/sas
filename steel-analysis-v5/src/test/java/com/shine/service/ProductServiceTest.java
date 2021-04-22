package com.shine.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@SpringBootTest
class ProductServiceTest {
    @Autowired
    ProductService service;

    @Test
    void getPage() {
        System.out.println(service.getPage(1,5));
    }

    @Test
    void test(){
        Date utilDate  = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("==========="+sqlDate);
    }
}