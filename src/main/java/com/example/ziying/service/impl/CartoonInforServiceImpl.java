package com.example.ziying.service.impl;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.CartoonInfor;
import com.example.ziying.mapper.CartoonInforMapper;
import com.example.ziying.service.CartoonInforService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class CartoonInforServiceImpl extends ServiceImpl<CartoonInforMapper, CartoonInfor> implements CartoonInforService {

    @Resource
    private CartoonInforMapper cartoonInforMapper;

    @Override
    public ResponseResult cartoonInforList() {
        List<CartoonInfor> cartoonInforList = cartoonInforMapper.selectCartoonInfor();
        return ResponseResult.success(cartoonInforList);
    }
}
