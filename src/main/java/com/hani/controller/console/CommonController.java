package com.hani.controller.console;

import com.alibaba.fastjson.JSONObject;
import com.hani.constant.CodeConstant;
import com.hani.controller.BaseController;
import com.hani.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/13 下午9:10.
 * </pre>
 */
@RequestMapping("/console/common")
@RestController
public class CommonController extends BaseController {

    @RequestMapping("/uploadFile")
    public Object uploadFile(HttpServletRequest request) {
        try {
            //创建一个通用的多部分解析器
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //判断 request 是否有文件上传,即多部分请求
            if (multipartResolver.isMultipart(request)) {
                //转换成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                //取得request中的所有文件名
                Iterator<String> iter = multiRequest.getFileNames();
                while (iter.hasNext()) {
                    //取得上传文件
                    MultipartFile file = multiRequest.getFile(iter.next());
                    if (file != null) {
                        //取得当前上传文件的文件名称
                        String myFileName = file.getOriginalFilename();
                        //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                        if (StringUtils.isNotBlank(myFileName)) {
                            //重命名上传后的文件名
                            String newFileName = new Date().getTime() + FileUtil.getFileSuffix(file.getOriginalFilename());
                            //定义上传路径
                            String relativePath = CodeConstant.CONSOLE_FILE_UPLOAD_PATH;
                            if (StringUtils.isNotBlank(file.getContentType()) && file.getContentType().indexOf("image") > -1) {
                                relativePath += CodeConstant.OTHER_IMG_UPLOAD_PATH;
                            }
                            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + relativePath;
                            String path = request.getSession().getServletContext().getRealPath(relativePath);
                            File targetFile = new File(path, newFileName);
                            if (!targetFile.exists()) {
                                targetFile.mkdirs();
                            }
                            file.transferTo(targetFile);
                            return getSuccess(url, newFileName);
                        }
                    }
                }
            }
            return getError("未上传文件");
        } catch (Exception e) {
            return getError(e.getMessage());
        }
    }

    private String getError(String message) {
        JSONObject obj = new JSONObject();
        obj.put("error", 1);
        obj.put("message", message);
        return obj.toJSONString();
    }

    private String getSuccess(String saveUrl, String newFileName) {
        JSONObject obj = new JSONObject();
        obj.put("error", 0);
        obj.put("url", saveUrl + newFileName);
        return obj.toJSONString();
    }

    public static void main(String[] args) {
    }

}