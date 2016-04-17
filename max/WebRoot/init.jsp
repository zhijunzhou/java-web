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
		<title>系统初始化</title>
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
						系统初始化
					</h3>
				</div>
				<div class="panel-body">
					<a href="account/init.do">开始初始化</a>
				</div>
			</div>
		</form>
		</div>
	</body>
</html>
