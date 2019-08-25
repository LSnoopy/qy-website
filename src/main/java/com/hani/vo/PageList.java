package com.hani.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/14 下午10:00.
 * </pre>
 */
public class PageList<T> implements Serializable {

    private int total;
    private List<T> rows;
    private int currPageNum = 1;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getCurrPageNum() {
        return currPageNum;
    }

    public void setCurrPageNum(int currPageNum) {
        this.currPageNum = currPageNum;
    }
}
