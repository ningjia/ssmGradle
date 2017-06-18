<%--
  Created by IntelliJ IDEA.
  User: jn
  Date: 2017/5/9
  Time: 下午4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
  <head>
    <title>CourseTest</title>
  </head>
  <body>
  CourseTest
  <hr>
  <div>
    <p>
      "教师信息"的内容为一对一的关联查询,"选课学生"的内容为一对多的关联查询,均使用@Select注解完成。
    </p>
    <p>
      "更新课程",使用@Update注解,更新课程的描述信息(course表的remark):修改后三位的随机数。
    </p>
    <p>
      查看课程,使用@SelectProvider注解,按照课程ID和课程名称的条件,查找出对应的课程信息。
    </p>
    <p>
      新增课程,使用@InsertProvider和@Insert注解,分别写入course表数据和student_course表数据。
    </p>
    <p>
      删除课程信息。
    </p>
    <p>
      删除课程信息,并通过事务进行控制,测试删除失败的回滚情况(未开发)。
    </p>

    <p>
      Ajax读取数据,并显示在画面的select元素中(未开发)。
    </p>
  </div>
  <hr>
  <div>
    <a href="/ssmGradle/redirect/jsp?url=course/addCourse" >新增课程</a>
  </div>
  <div>
    <table border="1">
      <tr>
        <th rowspan="2" >课程ID</th>
        <th rowspan="2">课程名称</th>
        <th rowspan="2">描述</th>
        <th colspan="3">教师信息</th>
        <th rowspan="2">选课学生</th>
        <th rowspan="2">操作</th>
      </tr>
      <tr>
        <th>教师ID</th>
        <th>教师姓名</th>
        <th>教师级别</th>
      </tr>

      <c:forEach items="${courses}" var="c">
        <tr>
          <!--课程信息-->
          <td>${c.id}</td>
          <td>${c.name}</td>
          <td>${c.remark}</td>
          <!--教师信息-->
          <td>${c.teacher.id}</td>
          <td>${c.teacher.name}</td>
          <td>${c.teacher.rank}</td>
          <td>
            <!--学生信息-->
              <c:forEach items="${c.students}" var="s">
                  ID:${s.id} ${s.name}
                  年龄:${s.age}
                  <c:if test="${s.sex=='1'}">&nbsp;(男)</c:if>
                  <c:if test="${s.sex=='0'}">&nbsp;(女)</c:if>
                  ${s.remark}
                  <br>
              </c:forEach>
          </td>
          <td>
            <a href="/ssmGradle/course/update?id=${c.id}" target="_blank">更新课程</a>
            <a href="/ssmGradle/course/getByIdAndName?id=${c.id}&name=${c.name}" target="_blank">查看课程</a>
            <a href="/ssmGradle/course/delete?id=${c.id}">删除课程</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>

  </body>
</html>
