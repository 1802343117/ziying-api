package com.example.ziying.controller;

import com.example.ziying.annotation.ControllerWebLog;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.dto.LoginDto;
import com.example.ziying.service.TelevisionService;
import com.example.ziying.service.UserInforService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
@Api(tags = "电视台接口", value = "提供电视台直播相关的API接口")
@Slf4j
public class TelevisionController {

    @Resource
    private TelevisionService televisionService;

    /**
     * 电视台直播
     *
     * @return String
     */
    @GetMapping("/television")
    @ControllerWebLog
    @ApiOperation(value = "提供所有电视台直播url", notes = "提供所有电视台直播url")
    public ResponseResult tVList() {
        return televisionService.tVList();
    }
}
