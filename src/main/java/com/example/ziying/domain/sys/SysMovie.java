package com.example.ziying.domain.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysMovie {

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

}
