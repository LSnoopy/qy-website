package com.hani.service.impl;

import com.hani.constant.CodeConstant;
import com.hani.constant.PromptConstant;
import com.hani.dao.SliderImgMapper;
import com.hani.domain.SliderImg;
import com.hani.domain.SliderImgCriteria;
import com.hani.service.SliderImgService;
import com.hani.util.FileUtil;
import com.hani.vo.PageList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 17/1/3 下午8:42.
 * </pre>
 */
@Service
@Transactional
public class SliderImgServiceImpl implements SliderImgService {

    @Autowired
    private SliderImgMapper sliderImgMapper;

    @Override
    public String saveSliderImg(MultipartFile file, HttpServletRequest request, SliderImg img) throws Exception {
        if (file == null) {
            throw new Exception(PromptConstant.IMG_NOT_SELECT);
        }
        //取得当前上传文件的文件名称
        String myFileName = file.getOriginalFilename();
        //如果名称不为“”,说明该文件存在，否则说明该文件不存在
        if (StringUtils.isNotBlank(myFileName)) {
            //重命名上传后的文件名
            String newFileName = new Date().getTime() + FileUtil.getFileSuffix(file.getOriginalFilename());
            //定义上传路径
            String relativePath = CodeConstant.CONSOLE_FILE_UPLOAD_PATH;
            if (StringUtils.isNotBlank(file.getContentType()) && file.getContentType().indexOf("image") > -1) {
                relativePath += CodeConstant.SLIDER_IMG_UPLOAD_PATH;
            }
//            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + relativePath;
            String path = request.getSession().getServletContext().getRealPath(relativePath);
            File targetFile = new File(path, newFileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            file.transferTo(targetFile);
            img.setUrl("/" + relativePath + newFileName);
            if (img.getId() != null && img.getId() > 0) {
                img.setModifyTime(new Date());
                sliderImgMapper.updateByPrimaryKeySelective(img);
            } else {
                img.setCreateTime(new Date());
                sliderImgMapper.insertSelective(img);
            }
            return "/" + relativePath + newFileName;
        }
        return "";
    }

    @Override
    public List<SliderImg> getList() {
        SliderImgCriteria sc = new SliderImgCriteria();
        sc.setOrderByClause("id asc");
        return sliderImgMapper.selectByExample(sc);
    }

    @Override
    public void delete(int id) {
        sliderImgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(int id) {
        SliderImg img = new SliderImg();
        img.setId(id);
        img.setUrl("");
        sliderImgMapper.updateByPrimaryKey(img);
    }
}
