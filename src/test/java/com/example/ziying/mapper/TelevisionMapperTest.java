package com.example.ziying.mapper;

import com.example.ziying.domain.entity.Television;
import com.example.ziying.spider.TelevisionSpider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest
class TelevisionMapperTest {

    @Resource
    private TelevisionMapper televisionMapper;

    @Test
    void selectTelevision() {
//        System.out.println(televisionMapper.selectTelevision());
        for (int i = 0; i < televisionMapper.selectTelevision().size(); i++) {
            System.out.println(i);
        }
    }

    @Test
    void addMultiterm() {
        List<Television> list = TelevisionSpider.getTelevisionList();
//        System.out.println(televisionList);
        televisionMapper.addTelevisionList(list);
    }
}