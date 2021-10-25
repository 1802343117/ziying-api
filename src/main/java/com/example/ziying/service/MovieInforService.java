package com.example.ziying.service;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.dto.FenYeDao;
import com.example.ziying.domain.entity.MovieInfor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ziying.domain.sys.SysMovie;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
public interface MovieInforService extends IService<MovieInfor> {

    /*
     * 所有电影
     * */
    ResponseResult movieInforList();

    /*
     * 搜索电影
     * */
    ResponseResult selectByMovieName(String movieName);

    /**
     * 各种影视类别分页
     * */
    ResponseResult selectByFenYe(FenYeDao fenYeDao);

    /**
     * 根据ID查找影视信息
     * */
    ResponseResult selectByMovieId(Integer movieId);

}
