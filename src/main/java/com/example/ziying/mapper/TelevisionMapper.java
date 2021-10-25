package com.example.ziying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ziying.domain.entity.Television;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
public interface TelevisionMapper extends BaseMapper<Television> {

    /**
     * 查询所有
     *
     * @return List<Television>
     */
    @Select("SELECT * FROM television")
    List<Television> selectTelevision();

    /**
     * 添加数据
     * @param television
     */
    @Insert("INSERT INTO television (television_id, television_name, television_pc_url, television_mobile_url)VALUES" +
            "(#{televisionId},#{televisionName},#{televisionPcUrl},#{televisionMobileUrl})")
    void addTelevision(Television television);

    /**
     * 添加多条数据
     * @param list
     */
    @Insert("<script>" +
            "INSERT INTO television " +
            "(television_id, television_name, television_pc_url, television_mobile_url) VALUES " +
            "<foreach collection='list' item='obj' separator=','>" +
            "(#{obj.televisionId},#{obj.televisionName},#{obj.televisionPcUrl},#{obj.televisionMobileUrl})" +
            "</foreach>" +
            "</script>")
    void addTelevisionList(List<Television> list);
}
