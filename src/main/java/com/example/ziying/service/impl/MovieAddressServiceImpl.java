package com.example.ziying.service.impl;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.MovieAddress;
import com.example.ziying.domain.sys.SysMovie;
import com.example.ziying.mapper.MovieAddressMapper;
import com.example.ziying.service.MovieAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class MovieAddressServiceImpl extends ServiceImpl<MovieAddressMapper, MovieAddress> implements MovieAddressService {

    @Resource
    private MovieAddressMapper movieAddressMapper;

    @Override
    public ResponseResult selectByMovieId(Integer movieId) {
        List<SysMovie> sysMovieList = movieAddressMapper.selectByMovieId(movieId);
        return ResponseResult.success(sysMovieList);
    }
}
