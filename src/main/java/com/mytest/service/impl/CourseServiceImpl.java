package com.mytest.service.impl;

import com.mytest.mapper.CourseMapper;
import com.mytest.mapper.StudentCourseMapper;
import com.mytest.pojo.Course;
import com.mytest.pojo.Student;
import com.mytest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void deleteCourse(Integer id) {
        //删除course表的数据
        int count_c = courseMapper.deleteCourse(id);
        //删除student_course表的数据
        int count_sc = scMapper.deleteStudentCourse(id);
        System.out.println("count_c表删除"+count_c+"行数据,count_sc表删除"+count_sc+"行数据");
    }

    @Override
    @Transactional
    public void deleteCourseWithTX(Integer id) throws Exception{
        //删除student_course表的数据
        int count_sc = scMapper.deleteStudentCourse(id);
        //抛出运行时异常，事务回滚
        int i = 1 / 0;
        //删除course表的数据
        int count_c = courseMapper.deleteCourse(id);
    }


}
