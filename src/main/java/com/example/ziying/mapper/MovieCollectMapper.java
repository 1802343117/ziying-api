package com.example.ziying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ziying.domain.entity.MovieCollect;
import com.example.ziying.domain.entity.MovieInfor;
import com.example.ziying.domain.entity.UserWatch;
import org.apache.ibatis.annotations.Delete;
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
public interface MovieCollectMapper extends BaseMapper<MovieCollect> {

    /**
     * 根据用户ID查询
     */
    @Select("SELECT * FROM movie_infor WHERE movie_id IN (SELECT movie_id " +
            "FROM movie_collect WHERE user_id=#{userId})")
    List<MovieInfor> selectByCollectList(Integer userId);

    /**
     * 添加收藏
     * @param movieCollect
     */
    @Insert("INSERT INTO movie_collect (collect_id, user_id, movie_id)VALUES" +
            "(#{collectId}, #{userId}, #{movieId})")
    void addMovieCollect(MovieCollect movieCollect);

    /**
     * 删除收藏
     * @param collectId
     */
    @Delete("DELETE FROM movie_collect WHERE collect_id=#{collectId};")
    void deleteByCollectId(Integer collectId);
}
