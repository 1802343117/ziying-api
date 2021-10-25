package com.example.ziying.mapper;

import com.example.ziying.domain.dto.FenYeDao;
import com.example.ziying.domain.entity.MovieInfor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ziying.domain.entity.Television;
import com.example.ziying.domain.entity.UserInfor;
import com.example.ziying.domain.sys.SysMovie;
import org.apache.ibatis.annotations.Insert;
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
public interface MovieInforMapper extends BaseMapper<MovieInfor> {

    /**
     * 查询所有
     *
     * @return List<TUser>
     */
    @Select("SELECT * FROM movie_infor")
    List<MovieInfor> selectMovieInfor();

    /**
     * 添加多条数据
     * @param list
     */
    @Insert("<script>" +
            "INSERT INTO movie_infor " +
            "(movie_id, link_id, comment_id, movie_name, movie_release, movie_place, movie_leading, " +
            "movie_director, movie_intro, movie_cover, movie_score, movie_category, movie_biaoshi) VALUES " +
            "<foreach collection='list' item='obj' separator=','>" +
            "(#{obj.movieId},#{obj.linkId},#{obj.commentId},#{obj.movieName},#{obj.movieRelease}," +
            "#{obj.moviePlace},#{obj.movieLeading},#{obj.movieDirector},#{obj.movieIntro},#{obj.movieCover}," +
            "#{obj.movieScore},#{obj.movieCategory}, #{obj.movieBiaoshi})" +
            "</foreach>" +
            "</script>")
    void addMovieInforList(List<MovieInfor> list);

    /**
     * 根据影片名查找电影信息
     */
    @Select("SELECT * FROM movie_infor WHERE movie_name like '%${movieName}%'")
    List<MovieInfor> selectByMovieName(String movieName);

    /**
     * 各种影视类别分页
     */
    @Select("SELECT * FROM movie_infor WHERE movie_biaoshi=#{movieBiaoshi} limit 0,#{utilShu}")
    List<MovieInfor> selectByFenYe(FenYeDao fenYeDao);

    /**
     * 根据影片SysMovie
     */
    @Select("SELECT * FROM movie_infor WHERE movie_id=#{movieId}")
    MovieInfor selectByMovieId(Integer movieId);
}
