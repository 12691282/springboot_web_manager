<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/core/base.jsp"%>
<html>
<head>
    <title> - 登录</title>
    <link rel="shortcut icon" href="favicon.ico"> 
	<link href="/css/bootstrap.min.css"  rel="stylesheet"   media="screen">
    <link href="/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">
    <link href="/css/style.css?v=4.1.0" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated ">
        <div>
            <div>
                <h1 style="margin-left: -220px;" class="logo-name">welcome</h1>
            </div>
            <h3>欢迎使用</h3>

            <form class="m-t" id="login_form" method="post" action="toLogin">
	            <div class="form-group">
	           	 	<span id="login_warn">${loginInfo}</span>
	            </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="username" name="username" placeholder="用户名" maxlength="18" >
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password"  placeholder="密码" maxlength="18">
                </div>
                <input type="button" id="submit_but" class="btn btn-primary block full-width" value="登 录"/>
            </form>
        </div>
    </div>

 	<script type="text/javascript" src="/js/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		var login_form = $("#login_form");
		var login_warn = $("#login_warn");
		$("#submit_but").mouseup(function(){
			var username = $("#username").val();
			if(username.length == 0){
				login_warn.html("请输入账号!");
				return;
			}
			var password = $("#password").val();
			if(password.length == 0){
				login_warn.html("请输入密码!");
				return;
			}
			login_form.submit();
		})
	});
	</script>
</body>	
</html>
