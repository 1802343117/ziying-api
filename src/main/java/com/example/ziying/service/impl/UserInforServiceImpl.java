package com.example.ziying.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.common.ResultCode;
import com.example.ziying.domain.dto.AddUserDto;
import com.example.ziying.domain.dto.LoginDto;
import com.example.ziying.domain.dto.PartyLoginDao;
import com.example.ziying.domain.entity.MovieInfor;
import com.example.ziying.domain.entity.UserInfor;
import com.example.ziying.mapper.UserInforMapper;
import com.example.ziying.mapper.UserWatchMapper;
import com.example.ziying.service.RedisService;
import com.example.ziying.service.UserInforService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ziying.util.JwtTokenUtil;
import com.example.ziying.util.Md5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tunl
 * @since 2021-04-19
 */
@Service
public class UserInforServiceImpl extends ServiceImpl<UserInforMapper, UserInfor> implements UserInforService {

    @Resource
    UserInforMapper userInforMapper;
    @Resource
    private RedisService redisService;
    @Resource
    private UserWatchMapper userWatchMapper;


    @Override
    public ResponseResult login(LoginDto loginDto) {
        UserInfor userInfor = userInforMapper.selectByAccount(loginDto.getAccount());
        if ( userInfor != null) {
            //客户端密码加密后和数据库的比对
            String pass = Md5Util.getMd5(loginDto.getPassword(), true, 32);
            if ( userInfor.getPassword().equals(pass) ) {
                //通过该管理员的id、roles、私钥、指定过期时间生成token
                String token = JwtTokenUtil.getToken(Integer.toString(userInfor.getUserId()), JSONObject.toJSONString(userInfor), userInfor.getSalt(), new Date(System.currentTimeMillis() + 6000L * 1000L));
                //将私钥存入redis，在后面JWT拦截器中可以取出来对客户端请求头中的token解密
                redisService.set(Integer.toString(userInfor.getUserId()), userInfor.getSalt(), 100L);
                Map<String, Object> map = new TreeMap<>();
                map.put("user", userInfor);
                map.put("token", token);
                map.put("href", "https://www.yunedit.com/update/neice/androidDown?id=37578");
                // 添加用户观看记录
                List<MovieInfor> movieInforList = userWatchMapper.selectByMovieList(userInfor.getUserId());
                map.put("userWatch", movieInforList);
                return ResponseResult.success(map);
            } else {
                System.out.println("密码错误");
                log.error("密码错误");
                return ResponseResult.failure(ResultCode.USER_PASSWORD_ERROR);
//                throw new CustomException("密码错误", ResultCode.USER_PASSWORD_ERROR);
            }
        } else {
            System.out.println("用户名不存在");
            log.error("用户名不存在");
//            throw new CustomException("用户名不存在", ResultCode.USER_NOT_FOUND);
            return ResponseResult.failure(ResultCode.USER_NOT_FOUND);
        }
    }

    @Override
    public ResponseResult addUser(AddUserDto addUserDto) {
        UserInfor userInfor = new UserInfor();
        Md5Util md5Util = new Md5Util();
        String md5 = md5Util.getMd5(addUserDto.getPassword(), true, 32);
        userInfor.setAccount(addUserDto.getPhoneNumber());
        // 加密过后的密码
        userInfor.setPassword(md5);
        userInfor.setNickname("新用户5186");
        userInfor.setAvatar("0");
        userInfor.setPhoneNumber(addUserDto.getPhoneNumber());
        userInfor.setEmail(addUserDto.getEmail());
        userInfor.setSalt("avc");
        System.out.println(userInfor.toString());
        userInforMapper.addUserInfor(userInfor);
        return ResponseResult.failure(ResultCode.SUCCESS);
    }

    @Override
    public ResponseResult updateAvatar(UserInfor userInfor) {
        userInforMapper.updateUserInfor(userInfor);
        return ResponseResult.failure(ResultCode.USER_INFOR_SUCCESS);
    }

    @Override
    public ResponseResult updateUserInfor(UserInfor userInfor) {
        userInforMapper.updateUserInfor(userInfor);
        return ResponseResult.failure(ResultCode.USER_INFOR_SUCCESS);
    }

    @Override
    public ResponseResult partyLogin(PartyLoginDao partyLoginDao) {
        Map<String, Object> map = new TreeMap<>();
        UserInfor user = userInforMapper.selectByAccount(partyLoginDao.getAccount());
        // 判断是否第一次登录,若是第一次登录则添加用户信息
        if ( user == null ) {
            UserInfor userInfor = new UserInfor();
            Md5Util md5Util = new Md5Util();
            String md5 = md5Util.getMd5("123456", true, 32);
            userInfor.setAccount(partyLoginDao.getAccount());
            // 加密过后的密码
            userInfor.setPassword(md5);
            userInfor.setNickname(partyLoginDao.getNickname());
            userInfor.setAvatar(partyLoginDao.getAvatar());
            userInfor.setPhoneNumber("123456789");
            userInfor.setEmail("123456789@qq.com");
            userInfor.setSalt("avc");
            userInforMapper.addUserInfor(userInfor);
            user = userInforMapper.selectByAccount(partyLoginDao.getAccount());
        }
        //通过该管理员的id、roles、私钥、指定过期时间生成token
        String token = JwtTokenUtil.getToken(Integer.toString(user.getUserId()), JSONObject.toJSONString(user), user.getSalt(), new Date(System.currentTimeMillis() + 6000L * 1000L));
        //将私钥存入redis，在后面JWT拦截器中可以取出来对客户端请求头中的token解密
        redisService.set(Integer.toString(user.getUserId()), user.getSalt(), 100L);

        map.put("user", user);
        map.put("token", token);
        // 添加用户观看记录
        List<MovieInfor> movieInforList = userWatchMapper.selectByMovieList(user.getUserId());
        map.put("userWatch", movieInforList);
        return ResponseResult.success(map);
    }
}
