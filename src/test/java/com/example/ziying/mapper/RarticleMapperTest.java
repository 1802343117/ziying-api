package com.example.ziying.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RarticleMapperTest {

    @Resource
    private RarticleMapper rarticleMapper;

    @Test
    void selectRarticle() {
        System.out.println(rarticleMapper.selectRarticle());
    }
}