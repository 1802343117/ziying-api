package com.example.ziying.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.entity.*;
import com.example.ziying.mapper.*;
import com.example.ziying.service.TelevisionService;
import com.example.ziying.service.UserInforService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@Service
public class TelevisionServiceImpl implements TelevisionService {

    @Resource
    TelevisionMapper televisionMapper;

    @Override
    public ResponseResult tVList() {
        List<Television> televisionList = televisionMapper.selectTelevision();
        Map<String, Object> map = new TreeMap<>();
        List<Television> tvList = new ArrayList<>();
        List<Television> tvList1 = new ArrayList<>();
        for (int i = 0; i < televisionList.size(); i++) {
//            System.out.println(i);
//            System.out.println(televisionList.get(i).getTelevisionName());
            if (televisionList.get(i).getTelevisionName().startsWith("CCTV") || televisionList.get(i).getTelevisionName().startsWith("CETV")) {
//                System.out.println(televisionList.get(i).getTelevisionName());
                tvList.add(televisionList.get(i));
            } else {
                tvList1.add(televisionList.get(i));
            }
        }
        map.put("cctv", tvList);
        map.put("region", tvList1);
        return ResponseResult.success(map);
    }
}
