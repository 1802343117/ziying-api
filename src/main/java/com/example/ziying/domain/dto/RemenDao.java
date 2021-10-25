package com.example.ziying.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.ziying.domain.entity.AttachedFiles;
import com.example.ziying.domain.entity.MovieComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemenDao {

    /**
     * 文章id
     */
    @TableId(value = "article_id")
    private Integer articleId;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 文章标题
     */
    @TableField("article_title")
    private String articleTitle;

    /**
     * 文章内容
     */
    @TableField("article_content")
    private String articleContent;

    /**
     * 文件时间标识
     */
    @TableField("article_date_sign")
    private String articleDateSign;

    /**
     * 附加文件
     */
    private List<String> attachedFiles;

    /**
     * 评论内容
     */
    private List<MovieComment> movieComments;

    private Boolean xiaoxi;

    private Boolean xihuan;

}
