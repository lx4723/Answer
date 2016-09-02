package com.answer.service;

import com.answer.entity.QuestionEntity;
import com.answer.util.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/1.
 */
public interface QuestionService {

    /**
     * 插入一条新数据
     * @param model 添加的数据
     */
    int insert(QuestionEntity model) throws Exception;
    /**
     * 根据ID删除
     * @param id 主键ID
     */
    int delete(Serializable id) throws Exception;
    /**
     * 更新一条数据
     * @param model 需要更新数据
     */
    int update(QuestionEntity model) throws Exception;
    /**
     * 根据ID获取
     * @param id 主键ID
     */
    QuestionEntity findById(Serializable id) throws Exception;
    /**
     * 获取全部数据
     */
    List<QuestionEntity> findAll() throws Exception;
    /**
     * 分页查询数据
     * @param size 每页显示的条数
     * @param start 开始页
     */
    PageInfo<QuestionEntity> findByPage(int start, int size) throws Exception;

}
