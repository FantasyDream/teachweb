<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
    #loginModal {
        position: absolute;
        top: 50%;
        -webkit-transform: translateY(-50%);
        -moz-transform: translateY(-50%);
        -ms-transform: translateY(-50%);
        -o-transform: translateY(-50%);
        transform: translateY(-50%);
    }
</style>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand">hello</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li><a href="#" style="color: white">首页</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="login.jsp" style="color: white">登陆</a></li>
        </ul>
    </div>
</nav>
<!--使用模态框的方式模拟一个登陆框-->
<div class="modal show" id="loginModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close">&times;</button>
                <h1 class="text-center text-primary">注册</h1>
            </div>
            <div class="modal-body">
                <form class="form col-md-12 center-block" id="registerForm" action="register" method="post">
                    <div class="form-group-lg" id="nameDiv">
                        <label class="sr-only" for="inputName">姓名</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                            </div>
                            <input class="form-control" id="inputName" name="name" type="text" placeholder="姓名" required
                                   autofocus>
                        </div>
                        <div class="hidden text-center" id="nameMsg">
                            <span class="glyphicon glyphicon-exclamation-sign"></span>
                        </div>
                    </div>
                    <br>
                    <div class="form-group-lg" id="accountDiv">
                        <label class="sr-only" for="inputAccount">手机号</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
                            </div>
                            <input class="form-control" id="inputAccount" name="phone" type="text" placeholder="手机号"
                                   required>
                        </div>
                        <div class="hidden text-center" id="accountMsg">
                            <span class="glyphicon glyphicon-exclamation-sign"></span>
                        </div>
                    </div>
                    <br>
                    <div class="form-group-lg" id="pwdDiv">
                        <label class="sr-only" for="inputPassword">密码</label>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock"></span>
                            </div>
                            <input class="form-control" id="inputPassword" name="password" type="password"
                                   placeholder="密码" required>
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-eye-open"></span>
                            </div>
                        </div>
                        <div class="hidden text-center" id="pwdMsg">
                            <span class="glyphicon glyphicon-exclamation-sign"></span>
                        </div>
                    </div>
                    <br>
                    <div class="form-group-lg">
                        <label class="sr-only" for="type">身份</label>
                        <div class="input-group">
                            <div class="input-group-addon"><span class="glyphicon glyphicon-th-list"></span></div>
                            <select class="form-control" name="type" id="type" placeholder="身份" required>
                                <option value="teacher">教师</option>
                                <option value="student">学生</option>
                                <option value="parent">家长</option>
                            </select>
                        </div>
                        <div class="hidden text-center">
                            <span class="glyphicon glyphicon-exclamation-sign"></span>
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <button class="btn btn-primary btn-lg col-md-6" id="btn_login" type="sumbit">注册</button>
                        <button class="btn btn-default btn-lg col-md-6" id="btn_reset" type="reset">重填</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer"></div>
        </div>
    </div>
</div>
</body>
</html>