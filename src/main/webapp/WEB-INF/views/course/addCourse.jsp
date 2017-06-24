<%--
  Created by IntelliJ IDEA.
  User: jn
  Date: 2017/5/9
  Time: 下午4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>AddCourse</title>
    <script type="text/javascript" src="<%=basePath%>/scripts/jquery-3.2.1.js"></script>
    <script>
        //加载教师列表
        $.ajax({
            type:"GET",
            url:"/ssmGradle/teacher/getTeachers",
            dataType:"json",
            data:{rank:'testValue'},
            success:function(data){
                if(data=="{}"){
                    alert("无发送数据!");
                }else{
                    $("#t_id").html("");
                    $.each(data,function(i, item) {
                        var statem = "<option value='"+item.id+"'>"+item.name+"("+item.rank+")"+"</option>";
                        $("#t_id").append(statem);
                    });
                }
            },
            error:function(){
                alert("ajax方法执行不成功!");
            }
        });
    </script>
</head>
<body>
AddCourse

<br>
<p>This is a paragraph.</p>
<button id="btn1">追加文本</button>

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
            <select name="t_id" id="t_id">
                <!--
                <option value="1">Steve</option>
                <option value="2">Jessica</option>
                <option value="3">Tom</option>
                -->
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
