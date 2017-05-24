package com.mytest.service.impl;

import com.mytest.mapper.CourseMapper;
import com.mytest.pojo.Course;
import com.mytest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jn on 2017/5/22.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> getCourseList() {
        return courseMapper.getCourseListWithTeacher();
    }

    @Override
    public Course getCourse(Integer id) {
        return courseMapper.getCourseById(id);
    }

    @Override
    public Course getCourseByIdAndName(Integer id, String name) {
        return courseMapper.getCourseByIdWithSqlProvider(id, name);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateCourse(course);
    }

}
