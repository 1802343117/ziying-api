package com.example.ziying.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class UserWatch extends Model<UserWatch> {

    private static final long serialVersionUID = 1L;

    /**
     * 观看记录id
     */
    @TableId("watch_id")
    private Integer watchId;

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
