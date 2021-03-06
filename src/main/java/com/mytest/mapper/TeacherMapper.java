package com.mytest.mapper;

import com.mytest.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jn on 2017/5/22.
 */
public interface TeacherMapper {

    @Select("select id, name, rank from teacher where id=#{teacherId}")
    Teacher getTeacherById(Integer teacherId);

    @Select("select id, name, rank from teacher")
    public List<Teacher> getTeacherByRank();

}
