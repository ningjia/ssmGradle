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
    <title>AddCourse</title>
</head>
<body>
AddCourse
<hr>
<form action="/ssmGradle/course/add">
    <div style="background-color: antiquewhite">
        <p style="color: red">课程</p>
        <div>
            课程名称:<input type="text" name="name">
        </div>
        <div>
            课程描述:<input type="text" name="remark">
        </div>
    </div>

    <div style="background-color: lightcyan">
        <p style="color: red">教师</p>
        <div>
            <select name="t_id">
                <option value="1">Steve</option>
                <option value="2">Jessica</option>
                <option value="3">Tom</option>
            </select>
        </div>
    </div>

    <div style="background-color: peachpuff">
        <p style="color: red">学生信息</p>
        <input type="checkbox" name="students[0].id" value="1">张三
        <input type="checkbox" name="students[1].id" value="2">李四
        <input type="checkbox" name="students[2].id" value="3">王五
    </div>
    <div>
        <input type="submit" value="提交">
    </div>

</form>
<div>

</div>
</body>
</html>
