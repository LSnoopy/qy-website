package com.hani.dao;

import com.hani.domain.SliderImg;
import com.hani.domain.SliderImgCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SliderImgMapper {
    /**
     * slider_img数据表的操作方法: countByExample  
     * 创建时间 : 2017-01-03 22:53:49
     */
    int countByExample(SliderImgCriteria example);

    /**
     * slider_img数据表的操作方法: deleteByExample  
     * 创建时间 : 2017-01-03 22:53:49
     */
    int deleteByExample(SliderImgCriteria example);

    /**
     * slider_img数据表的操作方法: deleteByPrimaryKey  
     * 创建时间 : 2017-01-03 22:53:49
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * slider_img数据表的操作方法: insert  
     * 创建时间 : 2017-01-03 22:53:49
     */
    int insert(SliderImg record);

    /**
     * slider_img数据表的操作方法: insertSelective  
     * 创建时间 : 2017-01-03 22:53:49
     */
    int insertSelective(SliderImg record);

    /**
     * slider_img数据表的操作方法: selectByExample  
     * 创建时间 : 2017-01-03 22:53:49
     */
    List<SliderImg> selectByExample(SliderImgCriteria example);

    /**
     * slider_img数据表的操作方法: selectByPrimaryKey  
     * 创建时间 : 2017-01-03 22:53:49
     */
    SliderImg selectByPrimaryKey(Integer id);

    /**
     * slider_img数据表的操作方法: updateByExampleSelective  
     * 创建时间 : 2017-01-03 22:53:49
     */
    int updateByExampleSelective(@Param("record") SliderImg record, @Param("example") SliderImgCriteria example);

    /**
     * slider_img数据表的操作方法: updateByExample  
     * 创建时间 : 2017-01-03 22:53:49
     */
    int updateByExample(@Param("record") SliderImg record, @Param("example") SliderImgCriteria example);

    /**
     * slider_img数据表的操作方法: updateByPrimaryKeySelective  
     * 创建时间 : 2017-01-03 22:53:49
     */
    int updateByPrimaryKeySelective(SliderImg record);

    /**
     * slider_img数据表的操作方法: updateByPrimaryKey  
     * 创建时间 : 2017-01-03 22:53:49
     */
    int updateByPrimaryKey(SliderImg record);
}