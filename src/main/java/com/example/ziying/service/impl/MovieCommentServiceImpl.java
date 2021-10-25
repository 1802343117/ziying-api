package com.example.ziying.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.MovieComment;
import com.example.ziying.mapper.MovieCommentMapper;
import com.example.ziying.service.MovieCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@Service
public class MovieCommentServiceImpl extends ServiceImpl<MovieCommentMapper, MovieComment> implements MovieCommentService {

    @Resource
    private MovieCommentMapper movieCommentMapper;

    @Override
    public ResponseResult addMovieComment(String json) {
        // 获取当前日期
//        System.out.println(movieComment.toString());
        JSONObject mess = JSONObject.parseObject(json);
        LocalDate date = LocalDate.now();
        MovieComment movieComment = new MovieComment();
        movieComment.setArticleId(mess.getInteger("articleId"));
        movieComment.setCommentDate(date);
        movieComment.setCommentContent(mess.getString("commentContent"));
        movieComment.setUserName(mess.getString("userName"));
        movieCommentMapper.addMovieComment(movieComment);
        return ResponseResult.success();
    }
}
