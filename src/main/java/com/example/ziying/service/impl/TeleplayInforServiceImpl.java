package com.example.ziying.service.impl;

import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.TeleplayInfor;
import com.example.ziying.mapper.TeleplayInforMapper;
import com.example.ziying.service.TeleplayInforService;
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
public class TeleplayInforServiceImpl implements TeleplayInforService {

    @Resource
    private TeleplayInforMapper teleplayInforMapper;

    @Override
    public ResponseResult teleplayInforList() {
        List<TeleplayInfor> teleplayInforList = teleplayInforMapper.selectTeleplayInfor();
        return ResponseResult.success(teleplayInforList);
    }
}
