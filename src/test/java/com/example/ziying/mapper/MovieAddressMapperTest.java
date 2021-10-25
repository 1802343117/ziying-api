package com.example.ziying.mapper;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;


@SpringBootTest
public class MovieAddressMapperTest {

    @Resource
    private MovieAddressMapper movieAddressMapper;

    @Test
    public void selectUser() {
        System.out.println(movieAddressMapper.selectMovieAddress());
    }
}