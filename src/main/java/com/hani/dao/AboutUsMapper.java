package com.hani.dao;

import com.hani.domain.AboutUs;
import com.hani.domain.AboutUsCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AboutUsMapper {
    /**
     * about_us数据表的操作方法: countByExample  
     * 创建时间 : 2017-01-31 14:51:08
     */
    int countByExample(AboutUsCriteria example);

    /**
     * about_us数据表的操作方法: deleteByExample  
     * 创建时间 : 2017-01-31 14:51:08
     */
    int deleteByExample(AboutUsCriteria example);

    /**
     * about_us数据表的操作方法: deleteByPrimaryKey  
     * 创建时间 : 2017-01-31 14:51:08
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * about_us数据表的操作方法: insert  
     * 创建时间 : 2017-01-31 14:51:08
     */
    int insert(AboutUs record);

    /**
     * about_us数据表的操作方法: insertSelective  
     * 创建时间 : 2017-01-31 14:51:08
     */
    int insertSelective(AboutUs record);

    /**
     * about_us数据表的操作方法: selectByExampleWithBLOBs  
     * 创建时间 : 2017-01-31 14:51:08
     */
    List<AboutUs> selectByExampleWithBLOBs(AboutUsCriteria example);

    /**
     * about_us数据表的操作方法: selectByExample  
     * 创建时间 : 2017-01-31 14:51:08
     */
    List<AboutUs> selectByExample(AboutUsCriteria example);

    /**
     * about_us数据表的操作方法: selectByPrimaryKey  
     * 创建时间 : 2017-01-31 14:51:08
     */
    AboutUs selectByPrimaryKey(Integer id);

    /**
     * about_us数据表的操作方法: updateByExampleSelective  
     * 创建时间 : 2017-01-31 14:51:08
     */
    int updateByExampleSelective(@Param("record") AboutUs record, @Param("example") AboutUsCriteria example);

    /**
     * about_us数据表的操作方法: updateByExampleWithBLOBs  
     * 创建时间 : 2017-01-31 14:51:08
     */
    int updateByExampleWithBLOBs(@Param("record") AboutUs record, @Param("example") AboutUsCriteria example);

    /**
     * about_us数据表的操作方法: updateByExample  
     * 创建时间 : 2017-01-31 14:51:08
     */
    int updateByExample(@Param("record") AboutUs record, @Param("example") AboutUsCriteria example);

    /**
     * about_us数据表的操作方法: updateByPrimaryKeySelective  
     * 创建时间 : 2017-01-31 14:51:08
     */
    int updateByPrimaryKeySelective(AboutUs record);

    /**
     * about_us数据表的操作方法: updateByPrimaryKeyWithBLOBs  
     * 创建时间 : 2017-01-31 14:51:08
     */
    int updateByPrimaryKeyWithBLOBs(AboutUs record);

    /**
     * about_us数据表的操作方法: updateByPrimaryKey  
     * 创建时间 : 2017-01-31 14:51:08
     */
    int updateByPrimaryKey(AboutUs record);
}