package com.mytest.service;

import com.mytest.pojo.Teacher;

import java.util.List;

/**
 * Created by jn on 2017/6/20.
 */
public interface TeacherService {

    /**
     *
     * @param rank
     * @return
     */
    public List<Teacher> getTeacherList();


}
