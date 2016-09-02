package com.answer.util;

import java.util.LinkedList;
import java.util.List;

/**
 * 分页通用类
 * @param <T>
 */
public class PageInfo<T> {
    List<T> dataList = new LinkedList<T>();

    int          total;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

