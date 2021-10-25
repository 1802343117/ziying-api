package com.example.ziying.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfor extends Model<UserInfor> {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private Integer userId;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

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
     * 手机号码
     */
    @TableField("phone_number")
    private String phoneNumber;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 密钥
     */
    @TableField("salt")
    private String salt;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
