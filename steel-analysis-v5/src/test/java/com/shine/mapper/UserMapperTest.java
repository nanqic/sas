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
        user.withProvince("山东省")
                .withCity("青岛市")
                .withCounty("市南区")
                .withPhone("13503713050")
                .withEmail("1223456@qq.com")
                .withSex("男");
        for (int i = 11; i <= 20; i++) {
            user.withUsername("用户" + i);
            mapper.insertSelective(user);
        }

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