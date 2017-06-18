package com.mytest.mapper;

import com.mytest.pojo.Course;
import com.mytest.sqlProvider.CourseSqlProvider;
import org.apache.ibatis.annotations.Delete;
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


    /**
     * 根据课程ID,删除student_course表的数据
     * @param courseId 课程ID
     * @return
     */
    @Delete("delete from student_course where c_id=#{courseId}")
    public int deleteStudentCourse(int courseId);

}
