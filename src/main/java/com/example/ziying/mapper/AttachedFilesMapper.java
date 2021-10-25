package com.example.ziying.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ziying.domain.entity.AttachedFiles;
import com.example.ziying.domain.entity.MovieComment;
import com.example.ziying.domain.entity.MovieInfor;
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
public interface AttachedFilesMapper extends BaseMapper<AttachedFiles> {

    /**
     * 查询所有
     *
     * @return List<AttachedFiles>
     */
    @Select("SELECT * FROM attached_files")
    List<AttachedFiles> selectAttachedFiles();

    /**
     * 根据id查询所有附加图片地址
     */
    @Select("SELECT attached_img FROM attached_files WHERE article_id=#{articleId}")
    List<String> selectByArticleId(Integer articleId);

    /**
     * 添加附加文件
     * @param attachedFiles
     */
    @Insert("INSERT INTO attached_files (attached_id, article_id, attached_img)VALUES" +
            "(#{attachedId},#{articleId},#{attachedImg})")
    void addAttachedFiles(AttachedFiles attachedFiles);

    /**
     * 添加多条数据
     * @param list
     */
    @Insert("<script>" +
            "INSERT INTO attached_files " +
            "(attached_id, article_id, attached_img) VALUES " +
            "<foreach collection='list' item='obj' separator=','>" +
            "(#{obj.attachedId},#{obj.articleId},#{obj.attachedImg})" +
            "</foreach>" +
            "</script>")
    void addAttachedList(List<AttachedFiles> list);
}
