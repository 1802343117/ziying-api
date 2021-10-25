package com.example.ziying.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

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
@TableName("attached_files")
public class AttachedFiles extends Model<AttachedFiles> {

    private static final long serialVersionUID = 1L;

    /**
     * 附加文件id
     */
    @TableId(value = "attached_id", type = IdType.AUTO)
    private Integer attachedId;

    /**
     * 文章id
     */
    @TableId(value = "article_id")
    private Integer articleId;

    /**
     * 附加图片
     */
    @TableField("attached_img")
    private String attachedImg;

    @Override
    protected Serializable pkVal() {
        return this.attachedId;
    }
}
