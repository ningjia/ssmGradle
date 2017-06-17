package com.mytest.service.impl;

import com.mytest.mapper.CourseMapper;
import com.mytest.mapper.StudentCourseMapper;
import com.mytest.pojo.Course;
import com.mytest.pojo.Student;
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
    @Autowired
    StudentCourseMapper scMapper;

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

    @Override
    public void insertCourse(Course course) {
        //数据写入course表
        courseMapper.insertCourseWithSqlProvider(course);
        //数据写入student_course表
        for(Student s : course.getStudents()){
            if(s!=null && s.getId()!=null)
            scMapper.insertStudentCourse(s.getId(), course.getId());
        }
    }

}
