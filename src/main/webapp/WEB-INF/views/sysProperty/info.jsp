<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>系统参数配置信息</title>
  </head>
  <body>
    当前对应环境: ${properties.envName}
  <hr>
  JDBC配置信息
  <div>
    Driver: ${properties.driver}
    <br>
    Url: ${properties.url}
    <br>
    Username: ${properties.username}
    <br>
    Password: ${properties.password}
  </div>
  <hr>
  </body>
</html>
