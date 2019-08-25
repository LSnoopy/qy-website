package com.hani.service;

import com.hani.domain.News;
import com.hani.vo.NewsVo;
import com.hani.vo.PageList;
import com.hani.vo.query.NewsQry;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/14 下午9:59.
 * </pre>
 */
public interface NewsService {

    void saveOrUpdateNews(News news, String url);

    PageList<NewsVo> getList(NewsQry param) throws Exception;

    void delNews(Integer id);

    NewsVo getById(Integer id) throws Exception;

}
