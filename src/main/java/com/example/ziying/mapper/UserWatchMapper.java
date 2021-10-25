package com.example.ziying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ziying.domain.entity.MovieInfor;
import com.example.ziying.domain.entity.UserWatch;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
public interface UserWatchMapper extends BaseMapper<UserWatch> {

    /**
     * 根据用户ID查询
     */
    @Select("SELECT * FROM movie_infor WHERE movie_id IN (SELECT movie_id " +
            "FROM user_watch WHERE user_id=#{userId})")
    List<MovieInfor> selectByMovieList(Integer userId);

    /**
     * 添加观看记录
     * @param userWatch
     */
    @Insert("INSERT INTO user_watch (watch_id, user_id, movie_id)VALUES" +
            "(#{watchId}, #{userId}, #{movieId})")
    void addUserWatch(UserWatch userWatch);
}
