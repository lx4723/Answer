package com.answer.base;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @param <T>
 */
public interface IGenericDAO<T> {
    /**
     * 插入一条数据
     * @param t
     */
    void insert(T t);

    void delete(T t);

    void update(T t);

    T save(T t);

    T queryById(String id);

    List<T> queryAll();

    List<T> findByPage(HashMap<String, Object> map);
}
