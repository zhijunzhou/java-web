<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<base href="<%=basePath%>" />
		<title>Bai Max - 学习者注册</title>
		<link rel="shortcut icon" href="images/favicon.ico"
			type="image/x-icon" />
		<link href="css/styles.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<script src="js/jquery.min.js"></script>
		<script src="js/core.min.js"></script>
		<style>
#wrap {
	width: 400px;
	height: 400px;
	position: absolute;
	left: 50%;
	margin-left: -200px;
	top: 40%;
	margin-top: -200px;
}

.row {
	height: 55px;
}
</style>
	</head>
	<body>
		<div id="wrap">
		<form name="myform" id="myform" action="account/reg.do" method="post" target="_top">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						学习者注册
					</h3>
				</div>
				<div class="panel-body">
					<div class="row text-warning">
						<div class="col-lg-12">${loginError }${param.loginError }</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<input type="text" name="username" class="form-control" placeholder="登录名" required />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<input type="text" name="celphone" class="form-control" placeholder="手机号" required />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<input type="email" name="email" class="form-control" placeholder="邮箱" required />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<input type="password" name="password" class="form-control" placeholder="密码" required />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12 text-center">
							<button class="btn btn-primary btn-block" type="submit">
								注册
							</button>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 text-left">
							
						</div>
						<div class="col-lg-6 text-right">
							<a href="login.jsp">登录</a>
						</div>
					</div>
				</div>
			</div>
		</form>
		</div>
	</body>
</html>
