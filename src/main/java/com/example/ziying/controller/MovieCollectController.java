package com.example.ziying.controller;

import com.example.ziying.annotation.ControllerWebLog;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.MovieCollect;
import com.example.ziying.domain.entity.UserWatch;
import com.example.ziying.mapper.MovieCollectMapper;
import com.example.ziying.service.MovieCollectService;
import com.example.ziying.service.UserWatchService;
import io.lettuce.core.dynamic.annotation.Value;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
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
@RequestMapping("/movieCollect")
@Validated
@Api(tags = "影视收藏接口", value = "影视收藏相关的API接口")
@Slf4j
public class MovieCollectController {

    @Resource
    private MovieCollectService movieCollectService;

    /**
     * 测试POST请求
     *
     * @return String
     */
    @PostMapping("/selectByCollectList")
    @ControllerWebLog
    @ApiOperation(value = "用于获取用户影视收藏", notes = "用于获取用户影视收藏")
    public ResponseResult selectByCollectList(@RequestParam Integer userId) {
        return movieCollectService.selectByCollectList(userId);
    }

    /**
     * 测试POST请求
     *
     * @return String
     */
    @PostMapping("/addMovieCollect")
    @ControllerWebLog
    @ApiOperation(value = "用于添加用户影视收藏", notes = "用于添加用户影视收藏")
    public ResponseResult addMovieCollect(@RequestBody @Value MovieCollect movieCollect) {
        return movieCollectService.addMovieCollect(movieCollect);
    }

    /**
     * 测试POST请求
     *
     * @return String
     */
    @DeleteMapping("/deleteByCollectId")
    @ControllerWebLog
    @ApiOperation(value = "用于删除用户影视收藏", notes = "用于删除用户影视收藏")
    public ResponseResult deleteByCollectId(@RequestParam Integer collectId) {
        return movieCollectService.deleteByCollectId(collectId);
    }
}
