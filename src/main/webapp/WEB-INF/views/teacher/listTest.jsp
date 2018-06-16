<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>教学网站</title>
    <style>
        .bg-primary {
            color: #fff;
            background-color: #337ab7
        }
    </style>
</head>
<body>
<div id="allContent">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" >hello</a>
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
                        <a href="#" class="disabled list-group-item"> 功能 </a>
                        <a href="listClass" sid="43" class="list-group-item moduleItemLeft"> <span>查看班级</span> </a>
                        <a href="listTestAction?classId=${sessionScope.classs.id}" sid="11" class="list-group-item moduleItemLeft"> <span>查看测试</span> </a>
                        <a href="listStudent?classId=${sessionScope.classs.id}" sid="39" class="list-group-item moduleItemLeft"> <span>查看学生</span> </a>
                        <a href="createTest?classId=${sessionScope.classs.id}" sid="11" class="list-group-item moduleItemLeft"> <span>创建测试</span> </a>
                    </div>
                </nav>
            </td>
            <td style="padding-left:40px;padding-right:40px">
                <div id="s12" class="panel panel-default moduleItemRight">
                    <div class="panel-heading">
                        测试列表
                    </div>
                    <div class="panel-body">
                        <style>
                            a.module {
                                display: block;
                                width: 280px;
                                height: 150px;
                                margin: 30px;
                                padding: 15px;
                                background-color: #d9edf7;
                                float: left;
                                border-radius: 18px;
                                position: relative;
                            }

                            a.module span.moduleNumber {
                                position: absolute;
                                top: 120px;
                                left: 250px;
                                color: #BC8F8F;
                                background-color: #F5F5DC;
                                border: 1px green;
                            }

                            a.module span.progressBar {
                                display: inline-block;
                                position: absolute;
                                left: 0px;
                                top: 170px;
                                width: 100%;
                            }

                            a.module:hover {
                                background-color: #dff0d8;
                            }
                        </style>
                        <c:forEach items="${tests}" var="test" varStatus="st">
                            <a href="listSubjectAction?testId=${test.id}" class="module" class="module">
                                <span class="moduleName pull-right">【${test.name}】</span>
                                <br/>
                                <br/>
                                <span>${test.name}</span>
                                <span class="badge moduleNumber pull-right"><c:out value="${st.count}" /></span>
                                <span class="progressBar"></span>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>

</body>
</html>
