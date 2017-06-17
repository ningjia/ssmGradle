package com.mytest.mapper;

import com.mytest.pojo.Course;
import com.mytest.sqlProvider.CourseSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Update;

/**
 * Created by jn on 2017/6/3.
 */
public interface StudentCourseMapper {

    /**
     *
     * @param s_id student表主键
     * @param c_id course表主键
     */
    @InsertProvider(type = CourseSqlProvider.class, method = "insertStudentCourse")
    public void insertStudentCourse(Integer s_id, Integer c_id);
}
