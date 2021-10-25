package com.example.ziying.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TelevisionServiceTest {

    @Resource
    private TelevisionService televisionService;

    @Test
    void tVList() {
        System.out.println(televisionService.tVList());
    }
}