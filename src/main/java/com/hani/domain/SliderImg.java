package com.hani.domain;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class SliderImg implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slider_img.id
     * 创建时间 : 2017-01-03 20:36:02
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slider_img.url
     * 创建时间 : 2017-01-03 20:36:02
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slider_img.create_time
     * 创建时间 : 2017-01-03 20:36:02
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slider_img.modify_time
     * 创建时间 : 2017-01-03 20:36:02
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column slider_img.remark
     * 创建时间 : 2017-01-03 20:36:02
     */
    private String remark;

    /**
     * slider_img表的操作属性:serialVersionUID
     * 创建时间 : 2017-01-03 20:36:02
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 slider_img.id的get方法 
     * 创建时间 : 2017-01-03 20:36:02
     */
    public Integer getId() {
        return id;
    }

    /**
     * 数据字段 slider_img.id的set方法
     * 创建时间 : 2017-01-03 20:36:02
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 数据字段 slider_img.url的get方法 
     * 创建时间 : 2017-01-03 20:36:02
     */
    public String getUrl() {
        return url;
    }

    /**
     * 数据字段 slider_img.url的set方法
     * 创建时间 : 2017-01-03 20:36:02
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 数据字段 slider_img.create_time的get方法 
     * 创建时间 : 2017-01-03 20:36:02
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 数据字段 slider_img.create_time的set方法
     * 创建时间 : 2017-01-03 20:36:02
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 数据字段 slider_img.modify_time的get方法 
     * 创建时间 : 2017-01-03 20:36:02
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 数据字段 slider_img.modify_time的set方法
     * 创建时间 : 2017-01-03 20:36:02
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 数据字段 slider_img.remark的get方法 
     * 创建时间 : 2017-01-03 20:36:02
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 数据字段 slider_img.remark的set方法
     * 创建时间 : 2017-01-03 20:36:02
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}