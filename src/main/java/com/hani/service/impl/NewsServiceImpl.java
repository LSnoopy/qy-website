package com.hani.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hani.dao.NewsMapper;
import com.hani.domain.News;
import com.hani.domain.NewsCriteria;
import com.hani.service.NewsService;
import com.hani.vo.NewsVo;
import com.hani.vo.PageList;
import com.hani.vo.query.NewsQry;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/14 下午10:05.
 * </pre>
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public void saveOrUpdateNews(News news, String url) {
        if (news.getId() != null && news.getId() > 0) {
            news.setModifyTime(new Date());
            News dbNews = newsMapper.selectByPrimaryKey(news.getId());
            if (dbNews != null) {
                JSONObject jsonObject = new JSONObject();
                if (StringUtils.isNotBlank(dbNews.getRemark())) {
                    jsonObject = JSON.parseObject(dbNews.getRemark());
                }
                if (StringUtils.isNotBlank(url)) {
                    jsonObject.put("coverUrl", url);
                }
                news.setRemark(jsonObject.toJSONString());
            }
            newsMapper.updateByPrimaryKeySelective(news);
        } else {
            news.setRemark("{\"coverUrl\":\"" + url + "\"}");
            news.setCreateTime(new Date());
            newsMapper.insert(news);
        }
    }

    @Override
    public PageList<NewsVo> getList(NewsQry qry) throws Exception {
        NewsCriteria param = new NewsCriteria();
        param.setStart(qry.getOffset());
        param.setLimit(qry.getLimit());
        param.setOrderByClause("top_flag desc, create_time desc");
        if (StringUtils.isNotBlank(qry.getSort())) {
            param.setOrderByClause(qry.getSort() + " " + qry.getOrder());
        }
        NewsCriteria.Criteria crt = param.createCriteria();
        crt.andRemarkNotLike("%delFlag%");
        if (StringUtils.isNotBlank(qry.getTitle())) {
            crt.andTitleLike(qry.getTitle());
        }
        if (qry.getBeginTime() != null) {
            crt.andCreateTimeGreaterThanOrEqualTo(qry.getBeginTime());
        }
        if (qry.getEndTime() != null) {
            crt.andCreateTimeLessThanOrEqualTo(qry.getEndTime());
        }
        if (qry.getShowFlag() != null) {
            crt.andShowFlagEqualTo(qry.getShowFlag());
        }
        int total = newsMapper.countByExample(param);
        List<News> list = newsMapper.selectByExampleWithBLOBs(param);
        List<NewsVo> voList = new ArrayList<>(0);
        if (CollectionUtils.isNotEmpty(list)) {
            for (News news : list) {
                NewsVo vo = new NewsVo();
                PropertyUtils.copyProperties(vo, news);
                JSONObject jsonObject = new JSONObject();
                if (StringUtils.isNotBlank(news.getRemark())) {
                    jsonObject = JSON.parseObject(news.getRemark());
                }
                vo.setCoverImgUrl(jsonObject.getString("coverUrl"));
                voList.add(vo);
            }
        }
        PageList<NewsVo> pageList = new PageList<>();
        pageList.setTotal(total);
        pageList.setRows(voList);
        return pageList;
    }

    @Override
    public void delNews(Integer id) {
        News dbNews = newsMapper.selectByPrimaryKey(id);
        if (dbNews != null) {
            JSONObject jsonObject = new JSONObject();
            if (StringUtils.isNotBlank(dbNews.getRemark())) {
                jsonObject = JSON.parseObject(dbNews.getRemark());
            }
            jsonObject.put("delFlag", "1");
            News news = new News();
            news.setId(dbNews.getId());
            news.setRemark(jsonObject.toJSONString());
            newsMapper.updateByPrimaryKeySelective(news);
        }
    }

    @Override
    public NewsVo getById(Integer id) throws Exception {
        News news = newsMapper.selectByPrimaryKey(id);
        NewsVo vo = new NewsVo();
        PropertyUtils.copyProperties(vo, news);
        return vo;
    }
}
