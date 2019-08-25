package com.hani.vo.query;

import com.hani.vo.PageParam;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/10/23 下午5:14.
 * </pre>
 */
public class BaseQuery extends PageParam {
    private static final long serialVersionUID = -7998068475786676860L;

    /**
     * 搜索内容
     */
    private String search;

    /**
     * 排序的列名
     */
    private String sort;

    /**
     * asc、desc
     */
    private String order;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
