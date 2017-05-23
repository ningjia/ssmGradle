package com.mytest.controller;

import com.mytest.pojo.Course;
import com.mytest.pojo.Student;
import com.mytest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by jn on 2017/5/22.
 */
@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/course/list")
    public String list(ModelMap modelMap){
        //获取课程列表
        List<Course> list = courseService.getCourseList();
        modelMap.put("courses", list );
        return "course/courseList";
    }

}
