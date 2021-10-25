package com.example.ziying.service.impl;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.MovieCollect;
import com.example.ziying.domain.entity.MovieInfor;
import com.example.ziying.mapper.MovieCollectMapper;
import com.example.ziying.mapper.MovieCommentMapper;
import com.example.ziying.service.MovieCollectService;
import com.example.ziying.service.UserWatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@Service
public class MovieCollectServiceImpl implements MovieCollectService {

    @Resource
    private MovieCollectMapper movieCollectMapper;

    @Override
    public ResponseResult selectByCollectList(Integer userId) {
        List<MovieInfor> movieCollectList = movieCollectMapper.selectByCollectList(userId);
        return ResponseResult.success(movieCollectList);
    }

    @Override
    public ResponseResult addMovieCollect(MovieCollect movieCollect) {
        movieCollectMapper.addMovieCollect(movieCollect);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult deleteByCollectId(Integer collectId) {
        movieCollectMapper.deleteByCollectId(collectId);
        return ResponseResult.success();
    }
}
