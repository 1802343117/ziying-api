package com.example.ziying.service;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.MovieAddress;
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
public interface MovieAddressService extends IService<MovieAddress> {

    /**
     * 根据ID查找影视播放地址
     * */
    ResponseResult selectByMovieId(Integer movieId);

}
