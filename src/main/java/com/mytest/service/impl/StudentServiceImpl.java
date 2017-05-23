package com.mytest.service.impl;

import com.mytest.mapper.StudentMapper;
import com.mytest.pojo.Student;
import com.mytest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jn on 2017/5/19.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList(null);
    }

    @Override
    public Student getStudent(int id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public List<Student> getStudentListByCourseId() {
        return null;
    }

}
