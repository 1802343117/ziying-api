package com.example.ziying.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MovieCommentMapperTest {

    @Resource
    private MovieCommentMapper movieCommentMapper;

    @Test
    void selectMovieComment() {
        System.out.println(movieCommentMapper.selectMovieComment());
    }
}