<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path2 = request.getContextPath();
	String basePath2 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path2 + "/";
%>
<base href="<%=basePath2%>" />
<style>
#wrapper {
	width: 100%;
}

#main-top-nav {
	background: #5f7a76;
	margin-bottom: 0;
	border-bottom: 0;
}

.navbar-top-links {
	background: #fff;
}

.navbar-top-links li {
	display: inline-block;
	line-height: 50px;
}

.navbar-top-links li a {
	color: #5f7a76;
}

#sys-container {
	margin-top: 20px;
	width: 100%;
}

#sys-content {
	padding: 20px 20px;
}
.nav-logo {
	color: #ddd;
    text-shadow: 2px 3px 4px #000;
}
</style>
<!-- top banner  -->
<nav class="navbar navbar-default navbar-static-top active"	role="navigation" id="main-top-nav">
<div class="container-fluid">
	<div class="navbar-header">
		<h1 class="nav-logo">
			Bai Max - 后台管理系统
		</h1>
	</div>
	<ul class="nav navbar-top-links navbar-right visible-lg">
		<li class="dropdown active">
			<a href="teacher/list.do">教师 <i class="glyphicon glyphicon-user"></i>
			</a>
		</li>
		<li class="dropdown active">
			<a href="lesson/filterlist.do">课程 <i class="glyphicon glyphicon-tasks"></i>
			</a>
		</li>
		<li class="dropdown active">
			<a href="student/list.do">学生 <i class="glyphicon glyphicon-tasks"></i>
			</a>
		</li>
		<li class="dropdown">
			<a href="teacher/orgList.do">机构 <i
				class="glyphicon glyphicon-briefcase"></i> </a>
		</li>
		<li class="dropdown">
			<a href="teacher/getOperatorOperations.do">运营 <i class="glyphicon glyphicon-blackboard"></i> </a>
		</li>
		<li class="dropdown">
			<a href="message/pwd.jsp">账户 <i class="glyphicon glyphicon-bell"></i> </a>
		</li>
		<li class="dropdown">
			<a href="account/logout.do">注销 <i class="glyphicon glyphicon-off"></i> </a>
		</li>
	</ul>
</div>
</nav>

<!-- end top banner -->