<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>教学网站</title>
</head>
<body>
<div id="allContent">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand">hello</a>
        </div>
        <div>
            <ul class="nav navbar-nav" >
                <li><a href="${sessionScope.login.type}/listClass" style="color: white">首页</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: white">${sessionScope.login.name}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/teachweb/userMessage">个人信息</a></li>
                        <li><a href="/teachweb/offline">退出</a></li>
                    </ul>
                </li>
                <li>&nbsp;&nbsp;</li>
            </ul>
        </div>
    </nav>

    <br/>

    <table width="100%" class="showTable1">
        <tr valign="top">
            <td width="60px" style="padding-left:20px">
                <nav>
                    <div style="width:150px">
                        <a href="#" class="disabled list-group-item"> 阶段 </a>
                        <a href="listTestAction?classId=${classs.id}" sid="43" class="list-group-item moduleItemLeft"> <span>查看所有测试</span> </a>
                        <a href="listGrade" sid="11" class="list-group-item moduleItemLeft"> <span>查看学生成绩</span> </a>
                        <a href="listSubjectAction?testId=${test.id}" class="list-group-item moduleItemLeft"><span>查看所有题目</span></a>
                    </div>
                </nav>
            </td>
            <td style="padding-left: 40px;padding-right:400px">
                <div id="s12" class="panel panel-default moduleItemRight">
                    <div class="panel-heading">
                        题目列表
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>学号</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>成绩</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${students}" var="Student" varStatus="st">
                                <tr>
                                    <td>${st.count}</td>
                                    <td>${Student.id}</td>
                                    <td>${Student.name}</td>
                                    <td>${Student.phone}</td>
                                    <td>${Student.grade}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
