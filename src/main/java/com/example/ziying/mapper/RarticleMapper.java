package com.example.ziying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ziying.domain.entity.MovieComment;
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
public interface RarticleMapper extends BaseMapper<Rarticle> {

    /**
     * 查询所有
     *
     * @return List<Rarticle>
     */
    @Select("SELECT * FROM r_article ORDER BY creation_time DESC")
    List<Rarticle> selectRarticle();

    /*
    * 根据用户id查询
    * */
    @Select("SELECT * FROM r_article WHERE user_id=#{userId}")
    List<Rarticle> selectByUserId(Integer userId);

    /*
     * 根据文章id查询
     * */
    @Select("SELECT * FROM r_article WHERE article_id=#{articleId}")
    List<Rarticle> selectByArticleId(Integer articleId);

    /**
     * 添加文章
     * @param rarticle
     */
    @Insert("INSERT INTO r_article (article_id, user_id, article_title, article_content, creation_time," +
            " nickname, avatar)VALUES" +
            "(#{articleId},#{userId},#{articleTitle},#{articleContent},#{creationTime}," +
            "#{nickname},#{avatar})")
    void addRarticle(Rarticle rarticle);
}
