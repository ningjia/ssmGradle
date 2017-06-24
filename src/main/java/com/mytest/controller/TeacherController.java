package com.mytest.controller;

import com.mytest.pojo.Teacher;
import com.mytest.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jn on 2017/6/20.
 */
@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    /**
     *
     * @param rank
     * @return
     */
    @RequestMapping(value = "/teacher/getTeachers", method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> getTeachers(String rank){
        System.out.println("rank="+rank);
        return teacherService.getTeacherList();
    }
}
