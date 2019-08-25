package com.hani.service;

import com.hani.domain.SliderImg;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 17/1/3 下午8:37.
 * </pre>
 */
public interface SliderImgService {

    String saveSliderImg(MultipartFile file, HttpServletRequest request, SliderImg img) throws Exception;

    List<SliderImg> getList();

    void delete(int id);

    void update(int id);
}
