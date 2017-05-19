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
    <title>AddUser</title>
</head>
<body>
AddUser
<hr>
<form action="/ssmGradle/user/add">
    <div>
        名称:<input type="text" name="name">
    </div>
    <div>
        密码:<input type="text" name="password">
    </div>
    <div>
        <input type="submit" value="提交">
    </div>


</form>
<div>

</div>
</body>
</html>
