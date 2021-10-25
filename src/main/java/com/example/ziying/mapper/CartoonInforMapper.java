package com.example.ziying.mapper;

import com.example.ziying.domain.entity.CartoonInfor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ziying.domain.entity.Television;
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
public interface CartoonInforMapper extends BaseMapper<CartoonInfor> {

    /**
     * 查询所有
     *
     * @return List<TUser>
     */
    @Select("SELECT * FROM cartoon_infor")
    List<CartoonInfor> selectCartoonInfor();

    /**
     * 添加多条数据
     * @param list
     */
    @Insert("<script>" +
            "INSERT INTO cartoon_infor " +
            "(cartoon_id, link_id, comment_id, cartoon_name, cartoon_release, cartoon_place, cartoon_leading, " +
            "cartoon_director, cartoon_intro, cartoon_cover, cartoon_score, cartoon_category) VALUES " +
            "<foreach collection='list' item='obj' separator=','>" +
            "(#{obj.cartoonId},#{obj.linkId},#{obj.commentId},#{obj.cartoonName},#{obj.cartoonRelease}," +
            "#{obj.cartoonPlace},#{obj.cartoonLeading},#{obj.cartoonDirector},#{obj.cartoonIntro},#{obj.cartoonCover}," +
            "#{obj.cartoonScore},#{obj.cartoonCategory})" +
            "</foreach>" +
            "</script>")
    void addCartoonInforList(List<CartoonInfor> list);

    /**
     * 根据影片
     */
    @Select("SELECT * FROM cartoon_infor WHERE cartoon_name=#{cartoonName}")
    CartoonInfor selectByCartoonName(String cartoonName);
}
