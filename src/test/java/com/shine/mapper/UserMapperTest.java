package com.shine.mapper;

import com.shine.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    void insert() {
        User user = new User();
        user.withUsername("Tim1")
                .withCity("LA")
                .withSex("male");
        mapper.insertSelective(user);
    }

    @Test
    void selectByPrimaryKey() {
        mapper.selectByPrimaryKey(1);
    }

    @Test
    void deleteByPrimaryKey() {
        mapper.deleteByPrimaryKey(4);
    }
}