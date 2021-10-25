package com.example.ziying.mapper;

import com.alibaba.fastjson.JSONObject;
import com.example.ziying.domain.entity.UserInfor;
import com.example.ziying.util.JwtTokenUtil;
import com.example.ziying.util.Md5Util;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class UserInforMapperTest {

    @Resource
    private UserInforMapper userInforMapper;

    /*
    * 查询用户信息表全部信息
    * */
    @Test
    public void selectUser() {
        System.out.println("LLL");
        System.out.println(userInforMapper.selectUserInfor());
    }

    /*
     * 证据用户账号查询用户信息
     * */
    @Test
    public void selectByAccount() {
        System.out.println(userInforMapper.selectByAccount("0"));
//        String token = JwtTokenUtil.getToken("123456", JSONObject.toJSONString(userInforMapper.selectByAccount("123")), "mySecrect", new Date(System.currentTimeMillis() + 60L * 1000L));
//        System.out.println("token加密：" + token);
//        System.out.println("adminId—————————" + JwtTokenUtil.getAdminId(token,"mySecrect"));
//        System.out.println("roles—————————" + JwtTokenUtil.getRoles(token,"mySecrect"));
    }

    /*
     * 根据ID删除用户信息
     * */
    @Test
    public void deleteById() {
        userInforMapper.deleteById(111);
        System.out.println(userInforMapper.selectUserInfor());
    }

    /*
     * 添加用户信息
     * */
    @Test
    public void addUserInfor() {
        UserInfor userInfor = new UserInfor();
        Md5Util md5Util = new Md5Util();
        String md5 = md5Util.getMd5("123", true, 32);
        userInfor.setAccount("111");
        userInfor.setPassword(md5);
        userInfor.setNickname("一一一");
        userInfor.setAvatar("");
        userInfor.setPhoneNumber("");
        userInfor.setEmail("");
        userInfor.setSalt("");
        System.out.println(userInfor.toString());
        userInforMapper.addUserInfor(userInfor);
        System.out.println(userInforMapper.selectUserInfor());
    }

    /*
     * 修改用户信息
     * */
    @Test
    public void updateUserInfor() {
        UserInfor userInfor = new UserInfor();
        userInfor.setUserId(2);
        userInfor.setAccount("123");
        userInfor.setPassword("123");
        userInfor.setNickname("一一一");
        userInfor.setAvatar("........................");
        userInfor.setPhoneNumber("********************");
        userInfor.setEmail("//////////////////////////");
        userInfor.setSalt("+++++++++++++++++++++++++");
        System.out.println(userInfor.toString());
        userInforMapper.updateUserInfor(userInfor);
        System.out.println(userInforMapper.selectUserInfor());

    }
}