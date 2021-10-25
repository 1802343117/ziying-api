package com.example.ziying;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
//注册过滤器注解
@ServletComponentScan
@MapperScan("com.example.ziying.mapper")
public class ZiyingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZiyingApplication.class, args);
    }
}
