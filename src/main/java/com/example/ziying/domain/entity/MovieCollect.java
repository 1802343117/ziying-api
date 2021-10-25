package com.example.ziying.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieCollect extends Model<MovieCollect> {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏id
     */
    @TableId("collect_id")
    private Integer collectId;

    /**
     * 用户id
     */
    @TableId("user_id")
    private Integer userId;

    /**
     * 电影id
     */
    @TableId("movie_id")
    private Integer movieId;

    @Override
    protected Serializable pkVal() {
        return this.movieId;
    }
}
