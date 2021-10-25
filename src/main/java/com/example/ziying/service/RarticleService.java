package com.example.ziying.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.CartoonInfor;
import com.example.ziying.domain.entity.Rarticle;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
public interface RarticleService extends IService<Rarticle> {

    /*
     * 所有文章
     * */
    ResponseResult articleList();

    /*
     * 用户的文章
     * */
    ResponseResult selectByUserId(Integer userId);

    /*
    * 添加文章
    * */
    ResponseResult addRarticle(Rarticle rarticle);
}
