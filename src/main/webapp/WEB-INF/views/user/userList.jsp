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
    <title>$Title$</title>
  </head>
  <body>
  UserTest
  <hr>
  系统时间:${serverTime}
  <div>
    用户数量:${users['count']}
    <a href="/ssmGradle/redirect/jsp?url=user/addUser">新增用户</a>
    <table border="1">
      <tr>
        <th>用户ID</th>
        <th>用户名称</th>
        <th>用户密码</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${users.list}" var="u">
        <tr>
          <td>${u.id}</td>
          <td>${u.name}</td>
          <td>${u.password}</td>
          <td>
            <a href="/ssmGradle/user/get?id=${u.id}" target="_blank">查看</a>
            <a href="/ssmGradle/user/update?id=${u.id}" >更新</a>
            <a href="/ssmGradle/user/delete?id=${u.id}" >删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
  </body>
</html>
