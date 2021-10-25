package com.example.ziying.controller;


import com.example.ziying.annotation.ControllerWebLog;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.mapper.MovieAddressMapper;
import com.example.ziying.service.MovieAddressService;
import com.example.ziying.service.MovieInforService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/movieAddress")
@Validated
@Api(tags = "电影详情相关接口", value = "电影详情相关接口")
@Slf4j
public class MovieAddressController {

    @Resource
    private MovieAddressService movieAddressService;

    @PostMapping("/selectByMovieId")
    @ControllerWebLog
    @ApiOperation(value = "查找电影播放地址", notes = "查找电影播放地址")
    public ResponseResult selectByMovieId(@RequestParam Integer movieId) {
        return movieAddressService.selectByMovieId(movieId);
    }

}
