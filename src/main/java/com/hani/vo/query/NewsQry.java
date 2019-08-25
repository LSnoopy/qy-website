package com.hani.vo.query;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/14 下午10:20.
 * </pre>
 */
public class NewsQry extends BaseQuery {
    private String title;
    private String beginTimeStr;
    private String endTimeStr;
    private Date beginTime;
    private Date endTime;
    private Boolean showFlag;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeginTimeStr() {
        return beginTimeStr;
    }

    public void setBeginTimeStr(String beginTimeStr) {
        this.beginTimeStr = beginTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public Date getBeginTime() {
        try {
            if (StringUtils.isNotBlank(this.beginTimeStr))
                return DateUtils.parseDate(this.beginTimeStr, "yyyy-MM-dd HH:mm");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Date getEndTime() {
        try {
            if (StringUtils.isNotBlank(this.endTimeStr))
                return DateUtils.parseDate(this.endTimeStr, "yyyy-MM-dd HH:mm");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(Boolean showFlag) {
        this.showFlag = showFlag;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(DateUtils.parseDate("2016-10-10 21:09", "yyyy-MM-dd HH:mm"));
    }
}
