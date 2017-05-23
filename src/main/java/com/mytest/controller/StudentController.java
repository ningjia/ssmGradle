package com.mytest.controller;

import com.mytest.pojo.Student;
import com.mytest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * Created by jn on 2017/5/19.
 */
@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student/list")
    public String list(ModelMap modelMap){
        //获取用户列表
        List<Student> list = studentService.getStudentList();
        modelMap.put("students", list );
        return "student/studentList";
    }

    /**
     * 获取一个指定的学生信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/student/get", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(Integer id){
        Student s = studentService.getStudent(id);
        return s;
    }
}
