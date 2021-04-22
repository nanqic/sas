package com.shine.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
@Autowired
UserService service;
    @Test
    void deleteByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(9);
        ids.add(10);
        service.updateByIds(ids);
    }
}