package com.answer.service.Impl;

import com.answer.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/9/2.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)                     //spring和junit整合，junit启动时加载springIoc容器
@ContextConfiguration({"classpath:spring/spring-*.xml"})    //告诉JUnit      spring 的配置文件
public class QuestionServiceImplTest {

    @Autowired
    QuestionService service ;

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testFindById() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {
          service.findAll();
    }

    @Test
    public void testFindByPage() throws Exception {

    }
}