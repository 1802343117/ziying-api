package com.example.ziying.controller;

import com.example.ziying.annotation.ControllerWebLog;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.AttachedFiles;
import com.example.ziying.domain.entity.Rarticle;
import com.example.ziying.service.RarticleService;
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
@RequestMapping("/article")
@Validated
@Api(tags = "热点文章相关接口", value = "热点文章相关接口")
@Slf4j
public class RarticleController {

    @Resource
    private RarticleService rarticleService;

    @GetMapping("/articleList")
    @ControllerWebLog
    @ApiOperation(value = "获取全部热点文章", notes = "获取全部热点文章")
    public ResponseResult articleList() {
        return rarticleService.articleList();
    }

    @GetMapping("/selectByUserId")
    @ControllerWebLog
    @ApiOperation(value = "获取用户热点文章", notes = "获取用户热点文章")
    public ResponseResult selectByUserId(@RequestParam Integer userId) {
        return rarticleService.selectByUserId(userId);
    }

    @PostMapping("/addRarticle")
    @ControllerWebLog
    @ApiOperation(value = "用于添加文章", notes = "用于添加文章")
    public ResponseResult addRarticle(@RequestBody @Valid Rarticle rarticle) {
        return rarticleService.addRarticle(rarticle);
    }
}
