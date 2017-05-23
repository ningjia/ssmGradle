<%--
  Created by IntelliJ IDEA.
  User: jn
  Date: 2017/5/9
  Time: 下午4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>StudentTest</title>
  </head>
  <body>
  StudentTest
  <hr>
  <div>
    通过@Select、@Results等注解,来进行单表的数据查询操作
  </div>
  <div>
    <table border="1">
      <tr>
        <th>学生ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>个人描述</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${students}" var="s">
        <tr>
          <td>${s.id}</td>
          <td>${s.name}</td>
          <td>${s.age}</td>
          <td>
            <c:if test="${s.sex=='1'}">男</c:if>
            <c:if test="${s.sex=='0'}">女</c:if>
          </td>
          <td>${s.remark}</td>
          <td>
            <a href="/ssmGradle/student/get?id=${u.id}" target="_blank">查看</a>
            <a href="/ssmGradle/student/update?id=${u.id}" >更新</a>
            <a href="/ssmGradle/studentstudents/delete?id=${u.id}" >删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>

  </body>
</html>
