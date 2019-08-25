package com.hani.controller.console;

import com.hani.constant.CodeConstant;
import com.hani.constant.PromptConstant;
import com.hani.controller.BaseController;
import com.hani.domain.News;
import com.hani.domain.SliderImg;
import com.hani.service.NewsService;
import com.hani.util.FileUtil;
import com.hani.vo.query.NewsQry;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Iterator;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/13 下午8:25.
 * </pre>
 */
@RestController
@RequestMapping("/console/news")
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/saveOrUpdate")
    public Object saveOrUpdate(HttpServletRequest request, News news) throws Exception {
        String url = uploadCoverImg(request);
        newsService.saveOrUpdateNews(news, url);
        return successResp();
    }

    @RequestMapping("/get")
    public Object getList(NewsQry param) throws Exception {
        return newsService.getList(param);
    }

    @RequestMapping("/delete")
    public Object delete(Integer id) {
        newsService.delNews(id);
        return successResp();
    }

    //    @RequestMapping("/uploadCoverImg")
//    @ResponseBody
    public String uploadCoverImg(HttpServletRequest request) throws Exception {
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
                url = saveImg(file, request);
            }
        }
        return url;
    }

    public String saveImg(MultipartFile file, HttpServletRequest request) throws Exception {

        //取得当前上传文件的文件名称
        String myFileName = file.getOriginalFilename();
        //如果名称不为“”,说明该文件存在，否则说明该文件不存在
        if (StringUtils.isNotBlank(myFileName)) {
            //重命名上传后的文件名
            String newFileName = new Date().getTime() + FileUtil.getFileSuffix(file.getOriginalFilename());
            //定义上传路径
            String relativePath = CodeConstant.CONSOLE_FILE_UPLOAD_PATH;
            if (StringUtils.isNotBlank(file.getContentType()) && file.getContentType().indexOf("image") > -1) {
                relativePath += CodeConstant.NEWS_COVER_IMG_UPLOAD_PATH;
            }
            String path = request.getSession().getServletContext().getRealPath(relativePath);
            File targetFile = new File(path, newFileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            file.transferTo(targetFile);

            return "/" + relativePath + newFileName;
        }
        return "";
    }
}
