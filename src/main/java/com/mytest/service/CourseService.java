package com.mytest.service;

import com.mytest.pojo.Course;
import com.mytest.pojo.Student;

import java.util.List;

/**
 * Created by jn on 2017/5/22.
 */
public interface CourseService {

    public List<Course> getCourseList();

    public Course getCourse(Integer id);

    public Course getCourseByIdAndName(Integer id, String name);

    public void updateCourse(Course course);
}
