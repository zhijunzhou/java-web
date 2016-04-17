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
		<title>Bai Max - 视频播放</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="在线课程，课程直播，在线教育，线下教育">
		<meta http-equiv="description" content="首页">

		<link href="css/styles.min.css" rel="stylesheet" />
		<link href="css/video-js.min.css" rel="stylesheet">
		<link href="css/pro.css" rel="stylesheet" />
		<script src="js/jquery.min.js"></script>
		<script src="js/core.min.js"></script>
		<script src="js/video.min.js"></script>
	</head>
	<body>
		<!-- top banner  -->
			<%@include file="/common/proHeader.jsp"%>
		<!-- end top banner -->
		<!-- right lesson detail -->
			<div class="container" style="margin-top: 51px;">
				
				<video id="really-cool-video" class="video-js vjs-default-skin col-md-12" controls
				 preload="auto" height="600" poster="really-cool-video-poster.jpg"
				 data-setup='{}'>
				  <source src="upload/lesson/${url }" type="video/mp4">
				  <source src="really-cool-video.webm" type="video/webm">
				  <p class="vjs-no-js">
				    To view this video please enable JavaScript, and consider upgrading to a web browser
				    that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
				  </p>
				</video>
			</div>
			
		<!-- right lesson detail -->
	</body>
</html>
