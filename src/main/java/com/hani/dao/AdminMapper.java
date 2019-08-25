package com.hani.dao;

import com.hani.domain.Admin;
import com.hani.domain.AdminCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    /**
     * admin数据表的操作方法: countByExample  
     * 创建时间 : 2016-12-12 23:05:47
     */
    int countByExample(AdminCriteria example);

    /**
     * admin数据表的操作方法: deleteByExample  
     * 创建时间 : 2016-12-12 23:05:47
     */
    int deleteByExample(AdminCriteria example);

    /**
     * admin数据表的操作方法: deleteByPrimaryKey  
     * 创建时间 : 2016-12-12 23:05:47
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * admin数据表的操作方法: insert  
     * 创建时间 : 2016-12-12 23:05:47
     */
    int insert(Admin record);

    /**
     * admin数据表的操作方法: insertSelective  
     * 创建时间 : 2016-12-12 23:05:47
     */
    int insertSelective(Admin record);

    /**
     * admin数据表的操作方法: selectByExample  
     * 创建时间 : 2016-12-12 23:05:47
     */
    List<Admin> selectByExample(AdminCriteria example);

    /**
     * admin数据表的操作方法: selectByPrimaryKey  
     * 创建时间 : 2016-12-12 23:05:47
     */
    Admin selectByPrimaryKey(Integer id);

    /**
     * admin数据表的操作方法: updateByExampleSelective  
     * 创建时间 : 2016-12-12 23:05:47
     */
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminCriteria example);

    /**
     * admin数据表的操作方法: updateByExample  
     * 创建时间 : 2016-12-12 23:05:47
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminCriteria example);

    /**
     * admin数据表的操作方法: updateByPrimaryKeySelective  
     * 创建时间 : 2016-12-12 23:05:47
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * admin数据表的操作方法: updateByPrimaryKey  
     * 创建时间 : 2016-12-12 23:05:47
     */
    int updateByPrimaryKey(Admin record);
}