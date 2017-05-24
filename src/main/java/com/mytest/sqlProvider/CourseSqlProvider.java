package com.mytest.sqlProvider;

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
}
