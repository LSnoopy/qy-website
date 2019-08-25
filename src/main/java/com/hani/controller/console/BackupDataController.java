package com.hani.controller.console;

import com.hani.service.NewsService;
import com.hani.vo.NewsVo;
import com.hani.vo.PageList;
import com.hani.vo.query.NewsQry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 17/2/23 下午9:00.
 * </pre>
 */
@Controller
public class BackupDataController {

    @Autowired
    private NewsService newsService;

    @ResponseBody
    @RequestMapping("/backup/news")
    public Object backupNews() throws Exception {
        NewsQry param = new NewsQry();
        param.setShowFlag(true);
        param.setOffset(0);
        param.setLimit(Integer.MAX_VALUE);
        PageList<NewsVo> list = newsService.getList(param);
        return list;
    }
}
