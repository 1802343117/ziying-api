package com.example.ziying.controller;


import com.example.ziying.annotation.ControllerWebLog;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.dto.FenYeDao;
import com.example.ziying.domain.sys.SysMovie;
import com.example.ziying.service.MovieInforService;
import com.example.ziying.util.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/movieInfor")
@Validated
@Api(tags = "电影详情相关接口", value = "电影详情相关接口")
@Slf4j
public class MovieInforController {

    @Resource
    private MovieInforService movieInforService;

    @GetMapping("/getMovieInfor")
    @ControllerWebLog
    @ApiOperation(value = "获取所有电影数据", notes = "获取所有电影数据")
    public ResponseResult getMovieInfor() {
        return movieInforService.movieInforList();
    }

    @PostMapping("/selectByMovieName")
    @ControllerWebLog
    @ApiOperation(value = "搜索电影", notes = "搜索电影")
    public ResponseResult selectByMovieName(@RequestParam String movieName) {
        return movieInforService.selectByMovieName(movieName);
    }

    @PostMapping("/selectByFenYe")
    @ControllerWebLog
    @ApiOperation(value = "分页", notes = "分页")
    public ResponseResult selectByMovieName(@RequestBody @Valid FenYeDao fenYeDao) {
        return movieInforService.selectByFenYe(fenYeDao);
    }

    @PostMapping("/selectByMovieId")
    @ControllerWebLog
    @ApiOperation(value = "查找电影", notes = "查找电影")
    public ResponseResult selectByMovieId(@RequestParam Integer movieId) {
        return movieInforService.selectByMovieId(movieId);
    }
}
