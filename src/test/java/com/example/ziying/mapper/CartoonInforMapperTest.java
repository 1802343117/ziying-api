package com.example.ziying.mapper;

import com.example.ziying.domain.entity.CartoonInfor;
import com.example.ziying.domain.entity.MovieInfor;
import com.example.ziying.spider.CartoonSpider;
import com.example.ziying.spider.MovieSpider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartoonInforMapperTest {

    @Resource
    private CartoonInforMapper cartoonInforMapper;

    @Test
    void selectCartoonInfor() {
        cartoonInforMapper.selectCartoonInfor();
    }

    @Test
    void addCartoonInforList() {
        String url = "http://www.zhoumody.com/type2/-----hits.html";
        List<CartoonInfor> cartoonList = CartoonSpider.getCartoonList(url);
        cartoonInforMapper.addCartoonInforList(cartoonList);
    }

    @Test
    void selectByCartoonName() {
        System.out.println(cartoonInforMapper.selectByCartoonName("名侦探柯南"));
    }
}