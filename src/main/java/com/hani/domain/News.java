package com.hani.domain;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.id
     * 创建时间 : 2017-01-31 14:49:23
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.type
     * 创建时间 : 2017-01-31 14:49:23
     */
    private Boolean type;

    /**
     * ?? -- news.title
     * 创建时间 : 2017-01-31 14:49:23
     */
    private String title;

    /**
     * ?????0-??1-? -- news.top_flag
     * 创建时间 : 2017-01-31 14:49:23
     */
    private Boolean topFlag;

    /**
     * ?????0-??1-? -- news.show_flag
     * 创建时间 : 2017-01-31 14:49:23
     */
    private Boolean showFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.create_time
     * 创建时间 : 2017-01-31 14:49:23
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.modify_time
     * 创建时间 : 2017-01-31 14:49:23
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.remark
     * 创建时间 : 2017-01-31 14:49:23
     */
    private String remark;

    /**
     * æ–°é—»æ¥æº -- news.source
     * 创建时间 : 2017-01-31 14:49:23
     */
    private String source;

    /**
     * ?? -- news.content
     * 创建时间 : 2017-01-31 14:49:23
     */
    private String content;

    /**
     * news表的操作属性:serialVersionUID
     * 创建时间 : 2017-01-31 14:49:23
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 news.id的get方法 
     * 创建时间 : 2017-01-31 14:49:23
     */
    public Integer getId() {
        return id;
    }

    /**
     * 数据字段 news.id的set方法
     * 创建时间 : 2017-01-31 14:49:23
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 数据字段 news.type的get方法 
     * 创建时间 : 2017-01-31 14:49:23
     */
    public Boolean getType() {
        return type;
    }

    /**
     * 数据字段 news.type的set方法
     * 创建时间 : 2017-01-31 14:49:23
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * 数据字段 news.title的get方法 
     * 创建时间 : 2017-01-31 14:49:23
     */
    public String getTitle() {
        return title;
    }

    /**
     * 数据字段 news.title的set方法
     * 创建时间 : 2017-01-31 14:49:23
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 数据字段 news.top_flag的get方法 
     * 创建时间 : 2017-01-31 14:49:23
     */
    public Boolean getTopFlag() {
        return topFlag;
    }

    /**
     * 数据字段 news.top_flag的set方法
     * 创建时间 : 2017-01-31 14:49:23
     */
    public void setTopFlag(Boolean topFlag) {
        this.topFlag = topFlag;
    }

    /**
     * 数据字段 news.show_flag的get方法 
     * 创建时间 : 2017-01-31 14:49:23
     */
    public Boolean getShowFlag() {
        return showFlag;
    }

    /**
     * 数据字段 news.show_flag的set方法
     * 创建时间 : 2017-01-31 14:49:23
     */
    public void setShowFlag(Boolean showFlag) {
        this.showFlag = showFlag;
    }

    /**
     * 数据字段 news.create_time的get方法 
     * 创建时间 : 2017-01-31 14:49:23
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 数据字段 news.create_time的set方法
     * 创建时间 : 2017-01-31 14:49:23
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 数据字段 news.modify_time的get方法 
     * 创建时间 : 2017-01-31 14:49:23
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 数据字段 news.modify_time的set方法
     * 创建时间 : 2017-01-31 14:49:23
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 数据字段 news.remark的get方法 
     * 创建时间 : 2017-01-31 14:49:23
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 数据字段 news.remark的set方法
     * 创建时间 : 2017-01-31 14:49:23
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 数据字段 news.source的get方法 
     * 创建时间 : 2017-01-31 14:49:23
     */
    public String getSource() {
        return source;
    }

    /**
     * 数据字段 news.source的set方法
     * 创建时间 : 2017-01-31 14:49:23
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 数据字段 news.content的get方法 
     * 创建时间 : 2017-01-31 14:49:23
     */
    public String getContent() {
        return content;
    }

    /**
     * 数据字段 news.content的set方法
     * 创建时间 : 2017-01-31 14:49:23
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}