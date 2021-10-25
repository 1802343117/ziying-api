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
@TableName("movie_address")
public class MovieAddress extends Model<MovieAddress> {

    private static final long serialVersionUID = 1L;

    /**
     * 播放地址id
     */
    @TableId("address_id")
    private Integer addressId;

    /**
     * 电影id
     */
    @TableField("movie_id")
    private Integer movieId;

    /**
     * 地址标记
     */
    @TableField("address_sign")
    private String addressSign;

    /**
     * 播放地址
     */
    @TableField("address")
    private String address;


    @Override
    protected Serializable pkVal() {
        return this.addressId;
    }

}
