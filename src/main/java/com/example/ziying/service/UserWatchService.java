package com.example.ziying.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.dto.LoginDto;
import com.example.ziying.domain.entity.UserWatch;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
public interface UserWatchService {

    /*
     * 获取观看记录
     * */
    ResponseResult selectByMovieList(Integer userId);

    /**
     * 添加观看记录
     * */
    ResponseResult addUserWatch(UserWatch userWatch);
}
