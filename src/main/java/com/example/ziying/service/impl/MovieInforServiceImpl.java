package com.example.ziying.service.impl;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.dto.FenYeDao;
import com.example.ziying.domain.entity.MovieInfor;
import com.example.ziying.domain.sys.SysMovie;
import com.example.ziying.mapper.MovieInforMapper;
import com.example.ziying.service.MovieInforService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.xpath.operations.Bool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@Service
public class MovieInforServiceImpl extends ServiceImpl<MovieInforMapper, MovieInfor> implements MovieInforService {

    @Resource
    private MovieInforMapper movieInforMapper;

    @Override
    public ResponseResult movieInforList() {
        List<MovieInfor> movieInforList = movieInforMapper.selectMovieInfor();

        // 动漫
        List<MovieInfor> cartoonList = new ArrayList<>();
        // 电影
        List<MovieInfor> movieList = new ArrayList<>();
        // 电视剧
        List<MovieInfor> teleplayList = new ArrayList<>();
        for (MovieInfor i: movieInforList) {
            if ( i.getMovieBiaoshi().equals("动漫") ) {
                cartoonList.add(i);
            }
            if ( i.getMovieBiaoshi().equals("电影") ) {
                movieList.add(i);
            }
            if ( i.getMovieBiaoshi().equals("电视剧") ) {
                teleplayList.add(i);
            }
        }
        Map<String, Object> map = new TreeMap<>();
        map.put("cartoonList", cartoonList);
        map.put("movieList", movieList);
        map.put("teleplayList", teleplayList);

        return ResponseResult.success(map);
    }

    @Override
    public ResponseResult selectByMovieName(String movieName) {
        List<MovieInfor> movieInfor = movieInforMapper.selectByMovieName(movieName);
        return ResponseResult.success(movieInfor);
    }

    @Override
    public ResponseResult selectByFenYe(FenYeDao fenYeDao) {
        List<MovieInfor> movieInfor = movieInforMapper.selectByFenYe(fenYeDao);
        Boolean bool = null;
        if ( fenYeDao.getUtilShu() > movieInfor.size() ) {
            bool = false;
        } else {
            bool = true;
        }
        Map<String, Object> map = new TreeMap<>();
        map.put("bool", bool);
        map.put("movieList", movieInfor);

        return ResponseResult.success(map);
    }

    @Override
    public ResponseResult selectByMovieId(Integer movieId) {
        MovieInfor movieInfor = movieInforMapper.selectByMovieId(movieId);
        return ResponseResult.success(movieInfor);
    }
}
