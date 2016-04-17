<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Bai Max - 首页</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="在线课程，课程直播，在线教育，线下教育">
		<meta http-equiv="description" content="首页">

		<link href="css/styles.min.css" rel="stylesheet" />
		<link href="css/pro.css" rel="stylesheet" />
		<script src="js/jquery.min.js"></script>
		<script src="js/core.min.js"></script>

	</head>

	<body>
		<!-- top banner  -->
			<%@include file="/common/proHeader.jsp"%>
		<!-- end top banner -->
		<%@include file="/common/margin.jsp" %>
		<!-- slider begin -->
			<%@include file="/pro/component/slider.jsp" %>
		<!-- slider end -->
		<%@include file="/lesson/component/hotest.jsp" %>
		<%@include file="/common/proFooter.jsp"%>
	</body>
</html>
