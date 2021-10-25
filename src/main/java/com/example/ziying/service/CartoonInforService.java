package com.example.ziying.service;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.CartoonInfor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
public interface CartoonInforService extends IService<CartoonInfor> {

    /*
     * 所有电影
     * */
    ResponseResult cartoonInforList();

}
