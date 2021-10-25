package com.example.ziying.service;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.MovieCollect;
import com.example.ziying.domain.entity.UserWatch;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
public interface MovieCollectService {
    /*
     * 获取收藏
     * */
    ResponseResult selectByCollectList(Integer userId);

    /**
     * 添加收藏
     * */
    ResponseResult addMovieCollect(MovieCollect movieCollect);

    /**
     * 删除收藏
     * */
    ResponseResult deleteByCollectId(Integer collectId);
}
