package com.example.ziying.service;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.dto.LoginDto;
import com.example.ziying.domain.dto.AddUserDto;
import com.example.ziying.domain.dto.PartyLoginDao;
import com.example.ziying.domain.entity.UserInfor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
public interface UserInforService extends IService<UserInfor> {

    /*
    * 用户登入
    * */
    ResponseResult login(LoginDto loginDto);

    /*
    * 用户注册
    * */
    ResponseResult addUser(AddUserDto addUserDto);

    /*
    * 修改头像
    * */
    ResponseResult updateAvatar(UserInfor userInfor);

    /*
     * 修改昵称
     * */
    ResponseResult updateUserInfor(UserInfor userInfor);

    /*
     * 第三方登录
     * */
    ResponseResult partyLogin(PartyLoginDao partyLoginDao);
}
