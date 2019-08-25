package com.hani.controller.website;

import com.hani.domain.News;
import com.hani.service.NewsService;
import com.hani.vo.NewsVo;
import com.hani.vo.PageList;
import com.hani.vo.query.NewsQry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 17/1/5 下午10:37.
 * </pre>
 */
@RequestMapping("/news")
@Controller("newsControllerW")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/list")
    public String list() {
        return "website/news/list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable() int id, HttpServletRequest request) throws Exception {
        request.setAttribute("news", newsService.getById(id));
        return "website/news/detail";
    }

    @ResponseBody
    @RequestMapping("/getList")
    public Object getList(NewsQry param) throws Exception {
        param.setShowFlag(true);
        param.setOffset((param.getCurrPageNum() - 1) * param.getLimit());
        PageList<NewsVo> pageList = newsService.getList(param);
        pageList.setCurrPageNum(param.getCurrPageNum());
        return pageList;
    }
}
