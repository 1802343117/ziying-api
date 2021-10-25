package com.example.ziying.service;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.MovieComment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
public interface MovieCommentService extends IService<MovieComment> {

    /*
     * 添加评论
     * */
    ResponseResult addMovieComment(String json);
}
