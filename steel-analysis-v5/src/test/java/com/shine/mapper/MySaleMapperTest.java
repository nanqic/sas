package com.shine.mapper;

import com.shine.model.vo.SaleView;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class MySaleMapperTest {
    @Autowired
    private MySaleMapper mySaleMapper;

    @Test
    void insertOrUpdate() {
        mySaleMapper.insertOrUpdate(1,1,880);
    }

    @Test
    void getAnaBySid() {
        Byte s = 2;

        log.info("{========}",mySaleMapper.getAnaBySid(s,"2021-01-2 20:08:08", "2021-04-17 21:50:04"));
    }
    @Test
    void select(){
        List<SaleView> findAll = mySaleMapper.findAll();
        log.info("********",findAll);
    }
}