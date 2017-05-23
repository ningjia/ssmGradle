package com.mytest.mapper;

import com.mytest.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by jn on 2017/5/19.
 */
public interface StudentMapper {

    /**
     * 查询学生列表
     */
    @Select("select id, name, age, sex, remark from student")
    public List<Student> getStudentList(Map<String, Object> params);

    /**
     * 查找student表中的一行数据
     * @param studId 学生ID
     * @return
     */
    @Select("select id, name, age, sex, remark from student where id=#{studId}")
    Student getStudentById(Integer studId);

    /**
     * 根据课程ID,查找出相关的学生信息列表
     * @param courseId 课程ID
     * @return
     */
    @Select("select s.id, s.name, s.age, s.sex, s.remark from student s inner join student_course sc on s.id=sc.s_id where sc.c_id=#{courseId}")
    public List<Student> getStudentListByCourseId(Integer courseId);

}
