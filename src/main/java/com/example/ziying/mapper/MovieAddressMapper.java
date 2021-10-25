package com.example.ziying.mapper;

import com.example.ziying.domain.entity.MovieAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ziying.domain.entity.UserInfor;
import com.example.ziying.domain.sys.SysMovie;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@Repository
public interface MovieAddressMapper extends BaseMapper<MovieAddress> {

    /**
     * 查询所有
     *
     * @return List<TUser>
     */
    @Select("SELECT * FROM movie_address")
    List<MovieAddress> selectMovieAddress();

    /**
     * 根据影片ID获取电影地址
     */
    @Select("SELECT * FROM movie_address WHERE movie_id=#{movieId}")
    List<SysMovie> selectByMovieId(Integer movieId);
}
