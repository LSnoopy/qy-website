package com.hani.controller.console;

import com.hani.controller.BaseController;
import com.hani.domain.SliderImg;
import com.hani.service.SliderImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 17/1/3 下午8:38.
 * </pre>
 */
@Controller
@RequestMapping("/console/slider")
public class SliderImgController extends BaseController {

    @Autowired
    private SliderImgService sliderImgService;

    @RequestMapping("/save")
    @ResponseBody
    public synchronized Object save(HttpServletRequest request, SliderImg img) throws Exception {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        String url = "";
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                url = sliderImgService.saveSliderImg(file, request, img);
            }
        }
        return successResp(url);
    }

    @RequestMapping("/getList")
    @ResponseBody
    public Object getList() {
        return sliderImgService.getList();
    }

    @RequestMapping("/del")
    @ResponseBody
    public Object del(int id) {
//        sliderImgService.delete(id);
        sliderImgService.update(id);
        return successResp();
    }
}
