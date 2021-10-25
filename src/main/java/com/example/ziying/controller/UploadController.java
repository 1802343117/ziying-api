package com.example.ziying.controller;


import com.example.ziying.annotation.ControllerWebLog;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.util.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
@Api(tags = "上传图片接口", value = "用于上传图片生成链接")
@Slf4j
public class UploadController {

    @PostMapping("/uploadFile")
    @ControllerWebLog
    @ApiOperation(value = "用于上传图片", notes = "用于上传图片")
    public ResponseResult uploadSingle(@RequestParam MultipartFile file) {
        String url = AliOssUtil.upload(file);
        return ResponseResult.success(url);
    }
}