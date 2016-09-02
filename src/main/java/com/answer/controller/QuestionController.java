package com.answer.controller;

import com.answer.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/9/1.
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService service;


    @RequestMapping("/findAll")
    @ResponseBody
    public Object  findAll() throws Exception {


        return service.findAll();
    }

}
