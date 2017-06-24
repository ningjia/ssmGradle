package com.mytest.service.impl;

import com.mytest.mapper.TeacherMapper;
import com.mytest.pojo.Teacher;
import com.mytest.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jn on 2017/6/20.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getTeacherList() {
        return teacherMapper.getTeacherByRank();
    }

}
