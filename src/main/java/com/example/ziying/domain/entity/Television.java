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
public class Television extends Model<Television>{

    private static final long serialVersionUID = 1L;

    /**
     * 电视台ID
     */
    @TableId("television_id")
    private Integer televisionId;

    /**
     * 电视台名称
     */
    @TableField("television_name")
    private String televisionName;

    /**
     * PC端
     */
    @TableField("television_pc_url")
    private String televisionPcUrl;

    /**
     * 移动端
     */
    @TableField("television_mobile_url")
    private String televisionMobileUrl;

    @Override
    protected Serializable pkVal() {
        return this.televisionId;
    }
}
