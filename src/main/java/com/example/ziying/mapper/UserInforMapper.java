package com.example.ziying.mapper;

import com.example.ziying.domain.entity.UserInfor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
public interface UserInforMapper extends BaseMapper<UserInfor> {

    /**
     * 查询所有
     *
     * @return List<TUser>
     */
    @Select("SELECT * FROM user_infor")
    List<UserInfor> selectUserInfor();

    /**
     * 根据账号查询
     */
    @Select("SELECT * FROM user_infor WHERE account=#{account}")
    UserInfor selectByAccount(String account);

    /**
     * 根据ID删除
     *
     * @param userId
     */
    @Delete("DELETE FROM user_infor WHERE user_id=#{userId}")
    void deleteById(Integer userId);

    /**
     * 添加用户
     * @param userInfor
     */
    @Insert("INSERT INTO user_infor (user_id, account, password, nickname, avatar, phone_number, email, salt)VALUES" +
            "(#{userId},#{account},#{password},#{nickname},#{avatar},#{phoneNumber},#{email},#{salt})")
    void addUserInfor(UserInfor userInfor);

    /**
     * 根据ID修改信息
     * @param userInfor
     */
    @Update("UPDATE user_infor SET user_id=#{userId}, account=#{account}, password=#{password}, nickname=#{nickname}, avatar=#{avatar}, phone_number=#{phoneNumber}, email=#{email}, salt=#{salt} WHERE user_id=#{userId}")
    void updateUserInfor(UserInfor userInfor);
}
