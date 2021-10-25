package com.example.ziying.controller;

import com.example.ziying.annotation.ControllerWebLog;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.UserWatch;
import com.example.ziying.service.UserWatchService;
import io.lettuce.core.dynamic.annotation.Value;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/userWatch")
@Validated
@Api(tags = "观看记录接口", value = "提供观看记录相关的API接口")
@Slf4j
public class UserWatchController {

    @Resource
    private UserWatchService userWatchService;

    /**
     * 测试POST请求
     *
     * @return String
     */
    @PostMapping("/selectByMovieList")
    @ControllerWebLog
    @ApiOperation(value = "用于获取用户观看记录", notes = "用于获取用户观看记录")
    public ResponseResult selectByMovieList(@RequestParam Integer userId) {
        return userWatchService.selectByMovieList(userId);
    }

    /**
     * 测试POST请求
     *
     * @return String
     */
    @PostMapping("/addUserWatch")
    @ControllerWebLog
    @ApiOperation(value = "用于添加用户观看记录", notes = "用于添加用户观看记录")
    public ResponseResult addUserWatch(@RequestBody @Value UserWatch userWatch) {
        return userWatchService.addUserWatch(userWatch);
    }
}
