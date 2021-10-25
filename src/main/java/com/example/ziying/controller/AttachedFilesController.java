package com.example.ziying.controller;

import com.example.ziying.annotation.ControllerWebLog;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.AttachedFiles;
import com.example.ziying.service.AttachedFilesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/attachedFiles")
@Validated
@Api(tags = "文章附加文件接口", value = "文章附加文件接口")
@Slf4j
public class AttachedFilesController {

    @Resource
    private AttachedFilesService attachedFilesService;

    @PostMapping("/addAttached")
    @ControllerWebLog
    @ApiOperation(value = "用于添加附加文件", notes = "用于添加附加文件")
    public ResponseResult addAttached(@RequestBody @Valid AttachedFiles attachedFiles) {
        return attachedFilesService.addAttached(attachedFiles);
    }

    @PostMapping("/selectByArticleId")
    @ControllerWebLog
    @ApiOperation(value = "用于获取附加文件", notes = "用于获取附加文件")
    public ResponseResult selectByArticleId(@RequestParam Integer articleId) {
        return attachedFilesService.selectByArticleId(articleId);
    }
}
