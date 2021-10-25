package com.example.ziying.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.AttachedFiles;
import com.example.ziying.domain.entity.MovieComment;

import java.lang.reflect.Array;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
public interface AttachedFilesService extends IService<AttachedFiles> {

    /*
     * 添加评论
     * */
    ResponseResult addAttached(AttachedFiles attachedFiles);

    /*
     * 根据id获取附加图片
     * */
    ResponseResult selectByArticleId(Integer articleId);
}
