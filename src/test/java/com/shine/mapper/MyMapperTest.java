package com.shine.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyMapperTest {
    @Autowired
    MyProductMapper myProductMapper;

    @Test
    void selectTest(){
        System.out.println(myProductMapper.findAll());
    }
}
