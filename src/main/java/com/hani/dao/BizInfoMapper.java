package com.hani.dao;

import com.hani.domain.BizInfo;
import com.hani.domain.BizInfoCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BizInfoMapper {
    /**
     * biz_info数据表的操作方法: countByExample  
     * 创建时间 : 2017-01-31 14:53:08
     */
    int countByExample(BizInfoCriteria example);

    /**
     * biz_info数据表的操作方法: deleteByExample  
     * 创建时间 : 2017-01-31 14:53:08
     */
    int deleteByExample(BizInfoCriteria example);

    /**
     * biz_info数据表的操作方法: deleteByPrimaryKey  
     * 创建时间 : 2017-01-31 14:53:08
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * biz_info数据表的操作方法: insert  
     * 创建时间 : 2017-01-31 14:53:08
     */
    int insert(BizInfo record);

    /**
     * biz_info数据表的操作方法: insertSelective  
     * 创建时间 : 2017-01-31 14:53:08
     */
    int insertSelective(BizInfo record);

    /**
     * biz_info数据表的操作方法: selectByExample  
     * 创建时间 : 2017-01-31 14:53:08
     */
    List<BizInfo> selectByExample(BizInfoCriteria example);

    /**
     * biz_info数据表的操作方法: selectByPrimaryKey  
     * 创建时间 : 2017-01-31 14:53:08
     */
    BizInfo selectByPrimaryKey(Integer id);

    /**
     * biz_info数据表的操作方法: updateByExampleSelective  
     * 创建时间 : 2017-01-31 14:53:08
     */
    int updateByExampleSelective(@Param("record") BizInfo record, @Param("example") BizInfoCriteria example);

    /**
     * biz_info数据表的操作方法: updateByExample  
     * 创建时间 : 2017-01-31 14:53:08
     */
    int updateByExample(@Param("record") BizInfo record, @Param("example") BizInfoCriteria example);

    /**
     * biz_info数据表的操作方法: updateByPrimaryKeySelective  
     * 创建时间 : 2017-01-31 14:53:08
     */
    int updateByPrimaryKeySelective(BizInfo record);

    /**
     * biz_info数据表的操作方法: updateByPrimaryKey  
     * 创建时间 : 2017-01-31 14:53:08
     */
    int updateByPrimaryKey(BizInfo record);
}