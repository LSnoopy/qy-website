package com.hani.dao;

import com.hani.domain.News;
import com.hani.domain.NewsCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    /**
     * news数据表的操作方法: countByExample  
     * 创建时间 : 2017-01-31 14:49:23
     */
    int countByExample(NewsCriteria example);

    /**
     * news数据表的操作方法: deleteByExample  
     * 创建时间 : 2017-01-31 14:49:23
     */
    int deleteByExample(NewsCriteria example);

    /**
     * news数据表的操作方法: deleteByPrimaryKey  
     * 创建时间 : 2017-01-31 14:49:23
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * news数据表的操作方法: insert  
     * 创建时间 : 2017-01-31 14:49:23
     */
    int insert(News record);

    /**
     * news数据表的操作方法: insertSelective  
     * 创建时间 : 2017-01-31 14:49:23
     */
    int insertSelective(News record);

    /**
     * news数据表的操作方法: selectByExampleWithBLOBs  
     * 创建时间 : 2017-01-31 14:49:23
     */
    List<News> selectByExampleWithBLOBs(NewsCriteria example);

    /**
     * news数据表的操作方法: selectByExample  
     * 创建时间 : 2017-01-31 14:49:23
     */
    List<News> selectByExample(NewsCriteria example);

    /**
     * news数据表的操作方法: selectByPrimaryKey  
     * 创建时间 : 2017-01-31 14:49:23
     */
    News selectByPrimaryKey(Integer id);

    /**
     * news数据表的操作方法: updateByExampleSelective  
     * 创建时间 : 2017-01-31 14:49:23
     */
    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsCriteria example);

    /**
     * news数据表的操作方法: updateByExampleWithBLOBs  
     * 创建时间 : 2017-01-31 14:49:23
     */
    int updateByExampleWithBLOBs(@Param("record") News record, @Param("example") NewsCriteria example);

    /**
     * news数据表的操作方法: updateByExample  
     * 创建时间 : 2017-01-31 14:49:23
     */
    int updateByExample(@Param("record") News record, @Param("example") NewsCriteria example);

    /**
     * news数据表的操作方法: updateByPrimaryKeySelective  
     * 创建时间 : 2017-01-31 14:49:23
     */
    int updateByPrimaryKeySelective(News record);

    /**
     * news数据表的操作方法: updateByPrimaryKeyWithBLOBs  
     * 创建时间 : 2017-01-31 14:49:23
     */
    int updateByPrimaryKeyWithBLOBs(News record);

    /**
     * news数据表的操作方法: updateByPrimaryKey  
     * 创建时间 : 2017-01-31 14:49:23
     */
    int updateByPrimaryKey(News record);
}