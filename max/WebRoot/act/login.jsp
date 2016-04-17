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
		<title>Bai Max - 登 录</title>
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
	top: 50%;
	margin-top: -200px;
}

.row {
	height: 55px;
}
</style>
	</head>
	<body>
		<div id="wrap">
		<form name="myform" id="myform" action="account/login.do" method="post" target="_top">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						登 录
					</h3>
				</div>
				<div class="panel-body">
					<div class="row text-warning">
						<div class="col-lg-12">${loginError }${param.loginError }</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<input type="text" name="username" class="form-control" placeholder="用户名" required />
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
								登 录
							</button>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 text-left">
							<a href="act/reg.jsp">注 册</a>
						</div>
						<div class="col-lg-6 text-right">
							<a href="#">忘记密码？</a>
						</div>
					</div>
				</div>
			</div>
		</form>
		</div>
	</body>
</html>
