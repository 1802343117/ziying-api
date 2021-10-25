package com.example.ziying.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TelevisionControllerTest {

    @Resource
    private TelevisionController televisionController;

    @Test
    void tVList() {
//        System.out.println(televisionController.tVList());
        String string = "CCTV";
        if ( string.equals("CCTV") ) {
            System.out.println("1");
        }
    }
}