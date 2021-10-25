package com.example.ziying.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ziying.common.ResponseResult;
import com.example.ziying.domain.dto.RemenDao;
import com.example.ziying.domain.entity.AttachedFiles;
import com.example.ziying.domain.entity.MovieComment;
import com.example.ziying.domain.entity.Rarticle;
import com.example.ziying.mapper.AttachedFilesMapper;
import com.example.ziying.mapper.MovieCommentMapper;
import com.example.ziying.mapper.RarticleMapper;
import com.example.ziying.service.RarticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
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
public class RarticleServiceImpl extends ServiceImpl<RarticleMapper, Rarticle> implements RarticleService {

    @Resource
    private RarticleMapper rarticleMapper;
    @Resource
    private MovieCommentMapper movieCommentMapper;
    @Resource
    private AttachedFilesMapper attachedFilesMapper;

    @Override
    public ResponseResult articleList() {
        Map<String, Object> map = new TreeMap<>();
        List<Rarticle> rarticleList = rarticleMapper.selectRarticle();
        List<RemenDao> remenDaoList = assemble(rarticleList);
        map.put("remen_list", remenDaoList);
        return ResponseResult.success(map);
    }

    @Override
    public ResponseResult selectByUserId(Integer userId) {
        Map<String, Object> map = new TreeMap<>();
        List<Rarticle> rarticleList = rarticleMapper.selectByUserId(userId);
        List<RemenDao> remenDaoList = assemble(rarticleList);
        map.put("remen_list", remenDaoList);
        return ResponseResult.success(map);
    }

    @Override
    public ResponseResult addRarticle(Rarticle rarticle) {
        LocalDateTime localDateTime = LocalDateTime.now();
        rarticle.setCreationTime(localDateTime);
        rarticleMapper.addRarticle(rarticle);
        // 返回编辑好的文章
        Map<String, Object> map = new TreeMap<>();
        List<Rarticle> rarticleList = rarticleMapper.selectByArticleId(rarticle.getArticleId());
        List<RemenDao> remenDaoList = assemble(rarticleList);
        map.put("remen_list", remenDaoList);
        return ResponseResult.success(map);
    }

    /*
    * 组装RemenDao类
    * */
    public List<RemenDao> assemble(List<Rarticle> rarticleList) {
        List<RemenDao> remenDaoList = new ArrayList<>();
        for (Rarticle rarticle: rarticleList) {
            RemenDao remenDao = new RemenDao();
            remenDao.setXiaoxi(false);
            remenDao.setXihuan(true);
            remenDao.setArticleId(rarticle.getArticleId());
            remenDao.setNickname(rarticle.getNickname());
            remenDao.setAvatar(rarticle.getAvatar());
            remenDao.setArticleTitle(rarticle.getArticleTitle());
            remenDao.setArticleContent(rarticle.getArticleContent());
            // 获取当前日期 完成时间标识的判断
            LocalDate date = LocalDate.now();
            int yearC = date.getYear() - rarticle.getCreationTime().toLocalDate().getYear();
            int monthC = date.get(ChronoField.MONTH_OF_YEAR) - rarticle.getCreationTime().toLocalDate().get(ChronoField.MONTH_OF_YEAR);
            int dayOfMonthC = date.getDayOfMonth() - rarticle.getCreationTime().toLocalDate().getDayOfMonth();
            if (yearC == 0) {
                if(monthC == 0) {
                    if(dayOfMonthC == 0) {
                        remenDao.setArticleDateSign("今天");
                    } else {
                        remenDao.setArticleDateSign(Integer.toString(dayOfMonthC) + "天前");
                    }
                } else {
                    remenDao.setArticleDateSign(Integer.toString(monthC) + "月前");
                }
            } else {
                remenDao.setArticleDateSign(Integer.toString(yearC) + "年前");
            }
            // 获取附加图片
            List<String> attachedFiles = attachedFilesMapper.selectByArticleId(rarticle.getArticleId());
            remenDao.setAttachedFiles(attachedFiles);
            // 获取文章相关评论
            List<MovieComment> movieComment = movieCommentMapper.selectByArticleId(rarticle.getArticleId());
            remenDao.setMovieComments(movieComment);
            remenDaoList.add(remenDao);
        }
        return remenDaoList;
    }
}
