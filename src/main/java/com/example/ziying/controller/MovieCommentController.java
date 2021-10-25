package com.example.ziying.controller;


import com.example.ziying.annotation.ControllerWebLog;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.MovieComment;
import com.example.ziying.domain.entity.UserInfor;
import com.example.ziying.service.MovieCommentService;
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
@RequestMapping("/movieComment")
@Validated
@Api(tags = "文章附加文件接口", value = "文章附加文件接口")
@Slf4j
public class MovieCommentController {

    @Resource
    private MovieCommentService movieCommentService;

    /*
     * 添加评论
     * */
    @PostMapping("/addComment")
    @ControllerWebLog
    @ApiOperation(value = "用于文章评论", notes = "用于文章评论")
    public ResponseResult addComment(@RequestBody @Valid String json) {
        return movieCommentService.addMovieComment(json);
    }

}
