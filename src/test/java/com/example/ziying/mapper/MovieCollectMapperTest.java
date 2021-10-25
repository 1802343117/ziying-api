package com.example.ziying.mapper;

import com.example.ziying.domain.entity.MovieCollect;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieCollectMapperTest {

    @Resource
    private MovieCollectMapper movieCollectMapper;

    @Test
    void selectByCollectList() {
        System.out.println(movieCollectMapper.selectByCollectList(0));
    }

    @Test
    void addMovieCollect() {
        MovieCollect movieCollect = new MovieCollect();
        movieCollect.setMovieId(0);
        movieCollect.setUserId(0);
        movieCollectMapper.addMovieCollect(movieCollect);
    }
}