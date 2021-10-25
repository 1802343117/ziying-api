package com.example.ziying.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("teleplay_infor")
public class TeleplayInfor extends Model<TeleplayInfor> {

    private static final long serialVersionUID = 1L;

    /**
     * 电视剧id
     */
    @TableId("teleplay_id")
    private Integer teleplayId;

    /**
     * 电视剧播放链接
     */
    @TableField("link_id")
    private Integer linkId;

    /**
     * 电视剧评论
     */
    @TableField("comment_id")
    private Integer commentId;

    /**
     * 电视剧名
     */
    @TableField("teleplay_name")
    private String teleplayName;

    /**
     * 电视剧上映时间
     */
    @TableField("teleplay_release")
    private String teleplayRelease;

    /**
     * 电视剧产地
     */
    @TableField("teleplay_place")
    private String teleplayPlace;

    /**
     * 电视剧主演
     */
    @TableField("teleplay_leading")
    private String teleplayLeading;

    /**
     * 电视剧导演
     */
    @TableField("teleplay_director")
    private String teleplayDirector;

    /**
     * 电视剧简介
     */
    @TableField("teleplay_intro")
    private String teleplayIntro;

    /**
     * 电视剧封面
     */
    @TableField("teleplay_cover")
    private String teleplayCover;

    /**
     * 电视剧评分
     */
    @TableField("teleplay_score")
    private float teleplayScore;

    /**
     * 电视剧类别
     * */
    @TableField("teleplay_category")
    private String teleplayCategory;


    @Override
    protected Serializable pkVal() {
        return this.teleplayId;
    }

}