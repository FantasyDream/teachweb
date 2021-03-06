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
<style>
    #loginModal{
        position: absolute;
        top: 38%;
        -webkit-transform: translateY(-50%);
        -moz-transform:  translateY(-50%);
        -ms-transform:  translateY(-50%);
        -o-transform:  translateY(-50%);
        transform:  translateY(-50%);
        /*background-color: #eee;*/
    }
</style>
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
            <td width="145px" style="padding-left:20px">
                <nav>
                    <div style="width:150px">
                        <a href="#" class="disabled list-group-item"> 功能 </a>
                        <a href="listClass" sid="43" class="list-group-item moduleItemLeft"> <span>查看班级</span> </a>
                        <a href="listTestAction?classId=${classs.id}" sid="11" class="list-group-item moduleItemLeft"> <span>查看测试</span> </a>
                        <a href="listStudent?classId=${classs.id}" sid="39" class="list-group-item moduleItemLeft"> <span>查看学生</span> </a>
                        <a href="createTest?classId=${classs.id}" sid="11" class="list-group-item moduleItemLeft"> <span>创建测试</span> </a>
                    </div>
                </nav>
            </td>
            <td width="280px">
                <div class="modal show" id="loginModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" onclick="history.back()">&times;</button>
                                <h1 class="text-center text-primary">创建测试</h1>
                            </div>
                            <div class="modal-body">
                                <form class="form col-md-12 center-block" id="loginForm" action="createTestAction" method="post">
                                    <div class="form-group-lg" id="nameDiv">
                                        <label class="sr-only" for="inputName">测试名</label>
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                            </div>
                                            <input class="form-control" id="inputName" name="testName" type="text" placeholder="测试名" required autofocus>
                                        </div>
                                        <div class="hidden text-center" id="nameMsg">
                                            <span class="glyphicon glyphicon-exclamation-sign"></span>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group-lg" id="subjectNoDiv">
                                        <label class="sr-only" for="inputsubjectNo">题目个数</label>
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                            </div>
                                            <input class="form-control" id="inputsubjectNo" name="subject_no" type="text" placeholder="题目个数" required autofocus>
                                        </div>
                                        <div class="hidden text-center" id="subjectNoMsg">
                                            <span class="glyphicon glyphicon-exclamation-sign"></span>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group-lg">
                                        <label class="sr-only" for="type">方式</label>
                                        <div class="input-group">
                                            <div class="input-group-addon"><span class="glyphicon glyphicon-th-list"></span></div>
                                            <select class="form-control" name="type" id="type" placeholder="方式" required>
                                                <option value="1">自动出题</option>
                                                <option value="2">随机选题</option>
                                            </select>
                                        </div>
                                        <div class="hidden text-center" >
                                            <span class="glyphicon glyphicon-exclamation-sign"></span>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <div class="col-md-1"></div>
                                        <button class="btn btn-primary btn-lg col-md-4" id="btn_create" type="sumbit">创建</button>
                                        <div class="col-md-2"></div>
                                        <button class="btn btn-primary btn-lg col-md-4" id="btn_reset" type="reset">重填</button>
                                        <div class="col-md-1"></div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>

</body>
</html>
