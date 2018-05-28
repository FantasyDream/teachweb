<%--
  Created by IntelliJ IDEA.
  User: FantasyDream
  Date: 2018/5/24
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register" method="post">
    姓&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" name="name"><br>
    手机号码:<input type="text" name="phone"><br>
    密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"><br>
    身&nbsp;&nbsp;&nbsp;&nbsp;份:<select name="type">
    <option value="teacher">教师</option>
    <option value="student">学生</option>
    <option value="parent">家长</option>
</select><br>
    <input type="submit" value="注册">
    <input type="reset" value="重填">
</form>
</body>
</html>
