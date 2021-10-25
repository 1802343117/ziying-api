package com.example.ziying.mapper;

import com.example.ziying.domain.entity.MovieInfor;
import com.example.ziying.domain.entity.TeleplayInfor;
import com.example.ziying.spider.MovieSpider;
import com.example.ziying.spider.TeleplayInforSpider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeleplayInforMapperTest {

    @Resource
    private TeleplayInforMapper teleplayInforMapper;

    @Test
    void selectTeleplayInfor() {
        System.out.println(teleplayInforMapper.selectTeleplayInfor());
    }

    @Test
    void addTeleplayInforList() {
        String url = "http://www.zhoumody.com/type2/-----gold-4.html";
        List<TeleplayInfor> teleplayList = TeleplayInforSpider.getTeleplayList(url);
        teleplayInforMapper.addTeleplayInforList(teleplayList);
    }
}