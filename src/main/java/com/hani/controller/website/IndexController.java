package com.hani.controller.website;

import com.hani.controller.BaseController;
import com.hani.domain.News;
import com.hani.domain.SliderImg;
import com.hani.service.NewsService;
import com.hani.service.SliderImgService;
import com.hani.vo.PageList;
import com.hani.vo.query.NewsQry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 17/1/2 上午10:38.
 * </pre>
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private SliderImgService sliderImgService;

    @Autowired
    private NewsService newsService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request) throws Exception {
        NewsQry param = new NewsQry();
        param.setShowFlag(true);
        param.setLimit(3);
        request.setAttribute("newsList", newsService.getList(param).getRows());
        return "website/index";
    }

    @RequestMapping("/getSliderImgs")
    @ResponseBody
    public Object getSliderImgs() {
        List<SliderImg> list = sliderImgService.getList();
        return successResp(list != null ? list : new String[0]);
    }
}
