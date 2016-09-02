package com.answer.service.Impl;

import com.answer.entity.QuestionEntity;
import com.answer.mapper.QuestionMapper;
import com.answer.service.QuestionService;
import com.answer.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/1.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper mapper;


    @Override
    public int insert(QuestionEntity model) throws Exception {
        return 0;
    }

    @Override
    public int delete(Serializable id) throws Exception {
        return 0;
    }

    @Override
    public int update(QuestionEntity model) throws Exception {
        return 0;
    }

    @Override
    public QuestionEntity findById(Serializable id) throws Exception {
        return null;
    }

    @Override
    public List<QuestionEntity> findAll() throws Exception {
        List<QuestionEntity> lists=mapper.queryAll();
        return lists;
    }

    @Override
    public PageInfo<QuestionEntity> findByPage(int start, int size) throws Exception {
        return null;
    }
}
