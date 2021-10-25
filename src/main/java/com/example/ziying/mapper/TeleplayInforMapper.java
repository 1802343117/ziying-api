package com.example.ziying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ziying.domain.entity.MovieInfor;
import com.example.ziying.domain.entity.TeleplayInfor;
import com.example.ziying.domain.entity.UserInfor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@Repository
public interface TeleplayInforMapper extends BaseMapper<MovieInfor> {

    /**
     * 查询所有
     *
     * @return List<TUser>
     */
    @Select("SELECT * FROM teleplay_infor")
    List<TeleplayInfor> selectTeleplayInfor();

    /**
     * 添加多条数据
     * @param list
     */
    @Insert("<script>" +
            "INSERT INTO teleplay_infor " +
            "(teleplay_id, link_id, comment_id, teleplay_name, teleplay_release, teleplay_place, teleplay_leading, " +
            "teleplay_director, teleplay_intro, teleplay_cover, teleplay_score, teleplay_category) VALUES " +
            "<foreach collection='list' item='obj' separator=','>" +
            "(#{obj.teleplayId},#{obj.linkId},#{obj.commentId},#{obj.teleplayName},#{obj.teleplayRelease}," +
            "#{obj.teleplayPlace},#{obj.teleplayLeading},#{obj.teleplayDirector},#{obj.teleplayIntro},#{obj.teleplayCover}," +
            "#{obj.teleplayScore},#{obj.teleplayCategory})" +
            "</foreach>" +
            "</script>")
    void addTeleplayInforList(List<TeleplayInfor> list);

    /**
     * 根据影片
     */
    @Select("SELECT * FROM teleplay_infor WHERE teleplay_name=#{teleplayName}")
    TeleplayInfor selectByTeleplayName(String teleplayName);
}
