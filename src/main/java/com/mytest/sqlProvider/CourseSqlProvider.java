package com.mytest.sqlProvider;

import com.mytest.pojo.Course;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by jn on 2017/5/24.
 */
public class CourseSqlProvider {

    /**
     * 提供Sql:根据课程ID和课程名称,查找一个指定的课程信息
     * @param param 参数map
     * @return
     */
    public String getCourseByIdAndName(Map param){
        /*读取参数,生成where语句*/
        Integer param_id = (Integer) param.get("param1");//Mapper中的参数,会以param1,param2(或0，1)等来作为key值
        String param_name = (String) param.get("param2");
        String str_where = "";
        if(param_id!=null){
            str_where += " and id="+param_id;
        }
        if(param_name!=null && !param_name.trim().equals("")){
            str_where += " and name='"+param_name+"'";
        }
        final String finalStr_where = str_where;
        /*拼装Sql语句*/
        return new SQL(){
            {
                SELECT("id, name, remark, t_id");
                FROM("course");
                WHERE("1=1"+finalStr_where);
            }
        }.toString();
    }

    /**
     * 提供Sql:在course表中插入数据
     * @param c
     * @return
     */
    public String insertCourse(Course c){
        return new SQL(){
            {
                INSERT_INTO("course");
                if(c.getName()!=null)
                    VALUES("name", "'"+c.getName()+"'");
                if(c.getRemark()!=null)
                    VALUES("remark", "#{remark}");//该种写法与上面name属性的写法都可以,但这种写法可以省去字符串外的引号
                if(c.getT_id()!=null)
                    VALUES("t_id", c.getT_id().toString());
            }
        }.toString();
    }

    /**
     * 提供Sql:在student_course表中插入数据。支持多个参数(使用Map来传递参数值)
     * @param param
     * @return
     */
    public String insertStudentCourse(Map param){
        //读取参数: Mapper中的参数,会以param1,param2(或0，1)等来作为key值
        Integer s_id = (Integer) param.get("param1");//
        Integer c_id = (Integer) param.get("param2");
        //构建sql语句
        return new SQL(){
            {
                INSERT_INTO("student_course");
                if(s_id!=null)
                    VALUES("s_id", s_id.toString());
                if(c_id!=null)
                    VALUES("c_id", c_id.toString());
            }
        }.toString();
    }

}
