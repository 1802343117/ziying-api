package com.example.ziying.service.impl;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.MovieInfor;
import com.example.ziying.domain.entity.UserWatch;
import com.example.ziying.mapper.UserWatchMapper;
import com.example.ziying.service.UserInforService;
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
public class UserWatchServiceImpl implements UserWatchService {

    @Resource
    private UserWatchMapper userWatchMapper;

    @Override
    public ResponseResult selectByMovieList(Integer userId) {
        List<MovieInfor> movieInforList = userWatchMapper.selectByMovieList(userId);
        return ResponseResult.success(movieInforList);
    }

    @Override
    public ResponseResult addUserWatch(UserWatch userWatch) {
        userWatchMapper.addUserWatch(userWatch);
        return ResponseResult.success();
    }
}
