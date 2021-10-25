package com.example.ziying.service;

import com.example.ziying.domain.dto.AddUserDto;
import com.example.ziying.domain.dto.LoginDto;
import com.example.ziying.domain.entity.UserInfor;
import com.example.ziying.util.Md5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInforServiceTest {

    @Resource
    private UserInforService userInforService;

    @Test
    void login() {
        LoginDto loginDto = new LoginDto();
        loginDto.setAccount("123");
        loginDto.setPassword("123");
        loginDto.setVerifyCode("avc");
        System.out.println("登录结果：" + userInforService.login(loginDto));
    }

    @Test
    void addUser() {
        AddUserDto addUserDto = new AddUserDto();
        addUserDto.setPassword("123");
        addUserDto.setPhoneNumber("123");
        addUserDto.setEmail("123");
        userInforService.addUser(addUserDto);
    }
}