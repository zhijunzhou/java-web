<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String pathNewTea = request.getContextPath();
	String basePathNewTea = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathNewTea + "/";
%>
<html>
	<head>
		<base href="<%=basePathNewTea%>" />
		<title>名师有约-后端数据管理系统</title>
		<link rel="shortcut icon" href="images/favicon.ico"	type="image/x-icon" />
		<link rel="stylesheet" href="css/styles.min.css"  />
		<link rel="stylesheet" href="css/AdminLTE.min.css">
		<link rel="stylesheet" href="css/skins/_all-skins.min.css">
		<link rel="stylesheet" href="css/style.css"  />
		<script src="js/jquery.min.js"></script>
		<script src="js/core.min.js"></script>
		<script src="js/app.min.js"></script>
		<script src="js/demo.js"></script>
	</head>
	<body class="hold-transition skin-blue sidebar-open sidebar-mini">
		<!-- Site wrapper -->
		<div class="wrapper">
			<%@include file="/common/topHeader.jsp"%>

			<%@include file="/common/leftMenu.jsp"%>

			<%@include file="/common/wrapAbove.jsp" %>
			<%@include file="/teacher/component/_newTeacher.jsp"%>
			<%@include file="/common/wrapUnder.jsp" %>

			<%@include file="/common/footer.jsp"%>
		</div>
		<!-- ./wrapper -->
	</body>
</html>
