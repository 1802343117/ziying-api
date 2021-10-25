package com.example.ziying.controller;


import com.example.ziying.annotation.ControllerWebLog;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.dto.LoginDto;
import com.example.ziying.domain.dto.AddUserDto;
import com.example.ziying.domain.dto.PartyLoginDao;
import com.example.ziying.domain.entity.UserInfor;
import com.example.ziying.mapper.UserInforMapper;
import com.example.ziying.service.UserInforService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/userInfor")
@Validated
@Api(tags = "用户接口", value = "提供用户相关的API接口")
@Slf4j
public class UserInforController {

    @Resource
    private UserInforService userInforService;

    @Resource
    private UserInforMapper userInforMapper;

    /**
     * 登录
     *
     * @return String
     */
    @PostMapping("/login")
    @ControllerWebLog
    @ApiOperation(value = "用于用户登录", notes = "用于用户登录")
    public ResponseResult login(@RequestBody @Valid LoginDto loginDto) {
        System.out.println(loginDto.getAccount());
        log.info(loginDto.toString());
        return userInforService.login(loginDto);
    }

    /**
     * 测试POST请求
     *
     * @return String
     */
    @GetMapping("/csPost")
    @ControllerWebLog
    @ApiOperation(value = "用于接口测试与调试", notes = "用于接口测试与调试")
    public ResponseResult csPost(@RequestParam String account) {
        return ResponseResult.success(userInforMapper.selectByAccount(account));
    }

    /**
     * 注册账号接口
     *
     * @return String
     */
    @PostMapping("/addUser")
    @ControllerWebLog
    @ApiOperation(value = "用于注册账号", notes = "用于注册账号")
    public ResponseResult addUser(@RequestBody @Valid AddUserDto addUserDto) {
        System.out.println(addUserDto.toString());
        return userInforService.addUser(addUserDto);
    }

    /*
     * 修改头像
     * */
    @PostMapping("/updateAvatar")
    @ControllerWebLog
    @ApiOperation(value = "用于用户头像修改", notes = "用于用户头像修改")
    public ResponseResult updateAvatar(@RequestBody @Valid UserInfor userInfor) {
        return userInforService.updateUserInfor(userInfor);
    }

    /*
    * 修改用户信息
    * */
    @PostMapping("/updateUserInfor")
    @ControllerWebLog
    @ApiOperation(value = "用于用户信息修改", notes = "用于用户信息修改")
    public ResponseResult updateUserInfor(@RequestBody @Valid UserInfor userInfor) {
        return userInforService.updateUserInfor(userInfor);
    }

    /*
    * 第三方登录
    * */
    @PostMapping("/partyLogin")
    @ControllerWebLog
    @ApiOperation(value = "用于第三方登录", notes = "用于第三方登录")
    public ResponseResult partyLogin(@RequestBody @Valid PartyLoginDao partyLoginDao) {
        return userInforService.partyLogin(partyLoginDao);
    }
}
