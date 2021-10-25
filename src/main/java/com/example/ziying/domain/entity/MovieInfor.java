package com.example.ziying.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("movie_infor")
public class MovieInfor extends Model<MovieInfor> {

    private static final long serialVersionUID = 1L;

    /**
     * 电影id
     */
    @TableId("movie_id")
    private Integer movieId;

    /**
     * 电影播放链接
     */
    @TableField("link_id")
    private Integer linkId;

    /**
     * 电影评论
     */
    @TableField("comment_id")
    private Integer commentId;

    /**
     * 电影名
     */
    @TableField("movie_name")
    private String movieName;

    /**
     * 电影上映时间
     */
    @TableField("movie_release")
    private String movieRelease;

    /**
     * 电影产地
     */
    @TableField("movie_place")
    private String moviePlace;

    /**
     * 电影主演
     */
    @TableField("movie_leading")
    private String movieLeading;

    /**
     * 电影导演
     */
    @TableField("movie_director")
    private String movieDirector;

    /**
     * 电影简介
     */
    @TableField("movie_intro")
    private String movieIntro;

    /**
     * 电影封面
     */
    @TableField("movie_cover")
    private String movieCover;

    /**
     * 电影评分
     */
    @TableField("movie_score")
    private float movieScore;

    /**
     * 电影类别
     * */
    @TableField("movie_category")
    private String movieCategory;

    /**
     * 标识
     * */
    @TableField("movie_biaoshi")
    private String movieBiaoshi;


    @Override
    protected Serializable pkVal() {
        return this.movieId;
    }

}
