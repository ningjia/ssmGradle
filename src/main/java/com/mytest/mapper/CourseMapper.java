package com.mytest.mapper;

import com.mytest.pojo.Course;
import com.mytest.sqlProvider.CourseSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by jn on 2017/5/22.
 */
public interface CourseMapper {

    /**
     * 查找所有的course表数据(包含关联的teacher表数据和student表数据)
     * @return
     */
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

    /**
     * 获取指定的课程信息
     * @param courseId 课程ID
     * @return
     */
    @Select("select * from course where id=#{courseId}")
    public Course getCourseById(Integer courseId);

    /**
     * 根据课程id和课程名称,获取课程信息。使用SqlProvide形式。
     * @param courseId 课程ID
     * @param courseName 课程名称
     * @return
     */
    @SelectProvider(type = CourseSqlProvider.class, method = "getCourseByIdAndName")
    public Course getCourseByIdWithSqlProvider(Integer courseId, String courseName);

    /**
     * 更新course表的数据
     * @param course
     */
    @Update("update course set name=#{name},remark=#{remark},t_id=#{t_id} where id=#{id}")
    public void updateCourse(Course course);

    /**
     * 插入course表的数据
     * @param course
     */
    @InsertProvider(type = CourseSqlProvider.class, method = "insertCourse")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    /* 获得insert所插入数据的主键
    *  keyProperty表示返回的id要保存到对象的哪个属性中。而useGeneratedKeys表示主键id为自增长模式。
    *  mysql的话只要加上这两个属性就可以了，加上后会自动把主键set到对象的属性上。
    * */
    public int insertCourseWithSqlProvider(Course course);

    /**
     * 根据课程ID,删除course表的数据
     * @param courseId 课程ID
     * @return
     */
    @Delete("delete from course where id=#{courseId}")
    public int deleteCourse(int courseId);

}
