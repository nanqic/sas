package com.shine.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MyOrderMapperTest {

    @Autowired
    private MyOrderMapper myOrderMapper;
    @Test
    void findAll() {
        System.out.println(myOrderMapper.findAll("v_order"));
    }
}