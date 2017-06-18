package com.mytest.controller;

import com.mytest.pojo.Course;
import com.mytest.service.CourseService;
import com.mytest.util.CommonTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/course/update", method = RequestMethod.GET)
    @ResponseBody
    public String update(Integer id){
        Course course = courseService.getCourse(id);
        if(course == null){
            return "课程数据不存在，courseId=" + id;
        }
        //修改描述中的三位随机数
        String remark = course.getRemark();
        remark = remark.substring(0,remark.length()-3);
        remark += CommonTool.getFixLenthString(3);
        course.setRemark(remark);
        //更新数据
        courseService.updateCourse(course);
        return "课程数据已更新，courseId=" + id + ", remark=" + remark;
    }

    @RequestMapping(value = "/course/getByIdAndName", method = RequestMethod.GET)
    @ResponseBody
    public Course getByIdAndName(Integer id, String name){
        return courseService.getCourseByIdAndName(id, name);
    }

    @RequestMapping(value = "/course/add")
    public String add(Course c){
        courseService.insertCourse(c);
        return "redirect:/course/list";//请求重定向
    }


    @RequestMapping(value = "/course/delete")
    public String delete(Integer id){
        courseService.deleteCourse(id);
        return "redirect:/course/list";//请求重定向
    }

}
