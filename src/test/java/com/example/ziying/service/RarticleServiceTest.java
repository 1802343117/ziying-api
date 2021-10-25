package com.example.ziying.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RarticleServiceTest {

    @Resource
    private RarticleService rarticleService;

    @Test
    void articleList() {
        System.out.println(rarticleService.articleList());
    }
}