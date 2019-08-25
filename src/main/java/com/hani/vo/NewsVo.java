package com.hani.vo;

import com.hani.domain.News;
import com.hani.util.HtmlUtil;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 17/1/8 上午12:00.
 * </pre>
 */
public class NewsVo extends News {

    //封面图地址
    private String coverImgUrl;

    private String source;

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getCreateTimeStr() {
        return getCreateTime() != null ? DateFormatUtils.format(getCreateTime(), "yyyy-MM-dd HH:mm:ss") : "";
    }

    public String getModifyTimeStr() {
        return getModifyTime() != null ? DateFormatUtils.format(getModifyTime(), "yyyy-MM-dd HH:mm:ss") : "";
    }

    public String getContentTxt() {
        String s = HtmlUtil.Html2Text(getContent());
        if (s != null && s.length() > 190) {
            s = s.substring(0, 180);
        }
        return s;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
