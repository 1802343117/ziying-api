package com.example.ziying.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FenYeDao {

    /**
     * 标识
     * */
    @TableField("movie_biaoshi")
    private String movieBiaoshi;

    /**
     * 工具数（用于分页）
     * */
    private int utilShu;
}
