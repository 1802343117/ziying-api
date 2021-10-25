package com.example.ziying.mapper;

import com.example.ziying.domain.entity.UserWatch;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserWatchMapperTest {
    @Resource
    private UserWatchMapper userWatchMapper;

    @Test
    void selectByMovieList() {
        System.out.println(userWatchMapper.selectByMovieList(0));
    }

    @Test
    void addUserWatch(){
        UserWatch watch = new UserWatch();
        watch.setMovieId(224);
        watch.setUserId(0);
        userWatchMapper.addUserWatch(watch);
    }
}