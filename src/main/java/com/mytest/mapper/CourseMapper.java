package com.mytest.mapper;

import com.mytest.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by jn on 2017/5/22.
 */
public interface CourseMapper {

    @Select("select * from course where 1=1")
    @Results(
            {
                @Result(id=true,column = "id",property = "id"),
                @Result(column = "name",property = "name"),
                @Result(column = "remark",property = "remark"),
                @Result(column = "t_id",property = "t_id"),
                @Result(column = "t_id",property = "teacher",
                    // 一对一映射,查找关联的teacher表数据
                    one = @One(select = "com.mytest.mapper.TeacherMapper.getTeacherById")
                ),
                @Result(column = "id",property = "students",
                    // 一对多映射,查找关联的student表数据
                    many = @Many(select = "com.mytest.mapper.StudentMapper.getStudentListByCourseId")
                )
            }
    )
    public List<Course> getCourseListWithTeacher();


}
