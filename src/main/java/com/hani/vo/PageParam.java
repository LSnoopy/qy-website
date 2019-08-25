package com.hani.vo;

import java.io.Serializable;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/14 下午10:22.
 * </pre>
 */
public class PageParam implements Serializable {
    private int offset;
    private int limit = 10;
    private int currPageNum = 1;

    public int getOffset() {
        return offset > 0 ? offset : 0;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCurrPageNum() {
        return currPageNum;
    }

    public void setCurrPageNum(int currPageNum) {
        this.currPageNum = currPageNum;
    }
}
