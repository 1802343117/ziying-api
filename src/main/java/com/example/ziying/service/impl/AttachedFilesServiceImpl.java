package com.example.ziying.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.AttachedFiles;
import com.example.ziying.mapper.AttachedFilesMapper;
import com.example.ziying.service.AttachedFilesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@Service
public class AttachedFilesServiceImpl extends ServiceImpl<AttachedFilesMapper, AttachedFiles> implements AttachedFilesService {

    @Resource
    private AttachedFilesMapper attachedFilesMapper;

    @Override
    public ResponseResult addAttached(AttachedFiles attachedFiles) {
//        System.out.println(list.toString());
        attachedFilesMapper.addAttachedFiles(attachedFiles);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult selectByArticleId(Integer articleId) {
        List<String> strings = attachedFilesMapper.selectByArticleId(articleId);
        return ResponseResult.success(strings);
    }
}
