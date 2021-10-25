package com.example.ziying.mapper;

import com.example.ziying.domain.dto.FenYeDao;
import com.example.ziying.domain.entity.MovieInfor;
import com.example.ziying.spider.MovieSpider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieInforMapperTest {
    @Resource
    private MovieInforMapper movieInforMapper;

    @Test
    void selectMovieInfor() {
        System.out.println(movieInforMapper.selectMovieInfor());
    }

    @Test
    void addMovieInforList() {
        String url = "http://www.zhoumody.com/type2/-----hits.html";
        List<MovieInfor> movieList = MovieSpider.getMovieList(url);
        movieInforMapper.addMovieInforList(movieList);
    }

    @Test
    void selectByMovieName() {
        System.out.println(movieInforMapper.selectByMovieName("名"));
    }

    @Test
    void selectByFenYe() {
        FenYeDao fenYeDao = new FenYeDao();
        fenYeDao.setMovieBiaoshi("动漫");
        fenYeDao.setUtilShu(8);
        System.out.println(movieInforMapper.selectByFenYe(fenYeDao));
    }
}