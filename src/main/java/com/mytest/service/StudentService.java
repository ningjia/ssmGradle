package com.mytest.service;

import com.mytest.pojo.Student;

import java.util.List;

/**
 * Created by jn on 2017/5/19.
 */
public interface StudentService {


    /**
     * 查询学生表的所有数据
     *
     * @return 学生数据
     */
    public List<Student> getStudentList();

    /**
     * 查询学生表的一行数据
     *
     * @return 学生数据
     */
    public Student getStudent(int id);

    /**
     *
     * @return
     */
    public List<Student> getStudentListByCourseId();

}
