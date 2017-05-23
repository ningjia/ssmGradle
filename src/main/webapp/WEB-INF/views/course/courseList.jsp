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
    <title>StudentTest</title>
  </head>
  <body>
  CourseTest
  <hr>
  <div>
    "教师信息"的内容为一对一的关联查询,"选课学生"的内容为一对多的关联查询
  </div>
  <div>
    <table border="1">
      <tr>
        <th rowspan="2" >课程ID</th>
        <th rowspan="2">课程名称</th>
        <th rowspan="2">描述</th>
        <th colspan="3">教师信息</th>
        <th rowspan="2">选课学生</th>
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
        </tr>
      </c:forEach>
    </table>
  </div>

  </body>
</html>
