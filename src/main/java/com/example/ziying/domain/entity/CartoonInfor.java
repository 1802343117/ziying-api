package com.example.ziying.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@TableName("cartoon_infor")
public class CartoonInfor extends Model<CartoonInfor> {

    private static final long serialVersionUID = 1L;

    /**
     * 电影id
     */
    @TableId("cartoon_id")
    private Integer cartoonId;

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
    @TableField("cartoon_name")
    private String cartoonName;

    /**
     * 电影上映时间
     */
    @TableField("cartoon_release")
    private String cartoonRelease;

    /**
     * 电影产地
     */
    @TableField("cartoon_place")
    private String cartoonPlace;

    /**
     * 电影主演
     */
    @TableField("cartoon_leading")
    private String cartoonLeading;

    /**
     * 电影导演
     */
    @TableField("cartoon_director")
    private String cartoonDirector;

    /**
     * 电影简介
     */
    @TableField("cartoon_intro")
    private String cartoonIntro;

    /**
     * 电影封面
     */
    @TableField("cartoon_cover")
    private String cartoonCover;

    /**
     * 电影评分
     */
    @TableField("cartoon_score")
    private float cartoonScore;

    /**
     * 电影类别
     * */
    @TableField("cartoon_category")
    private String cartoonCategory;


    @Override
    protected Serializable pkVal() {
        return this.cartoonId;
    }

}
