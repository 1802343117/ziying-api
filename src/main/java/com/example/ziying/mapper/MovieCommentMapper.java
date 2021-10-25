package com.example.ziying.mapper;

import com.example.ziying.domain.entity.MovieComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ziying.domain.entity.Rarticle;
import com.example.ziying.domain.entity.UserInfor;
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
public interface MovieCommentMapper extends BaseMapper<MovieComment> {

    /**
     * 查询所有
     *
     * @return List<MovieComment>
     */
    @Select("SELECT * FROM movie_comment")
    List<MovieComment> selectMovieComment();

    /**
     * 根据id查询
     */
    @Select("SELECT * FROM movie_comment WHERE article_id=#{articleId}")
    List<MovieComment> selectByArticleId(Integer articleId);

    /**
     * 添加文章评论
     * @param movieComment
     */
    @Insert("INSERT INTO movie_comment (comment_id, article_id, user_name, comment_content, comment_date)VALUES" +
            "(#{commentId},#{articleId},#{userName},#{commentContent},#{commentDate})")
    void addMovieComment(MovieComment movieComment);
}
