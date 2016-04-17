<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String pathPro = request.getContextPath();
	String basePathPro = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathPro + "/";
%>
<base href="<%=basePathPro%>">
<style>
.navbar-default .navbar-nav>li>a {
	color:#fff;
	font-size: 12px;
}
.navbar-default .navbar-nav>.active>a {
	color:#2d5638;
}
.navbar-default .navbar-brand  {
	color:#eee;
	font-size:24px;
	text-shadow: 2px 3px 4px #000;
}
.navbar-default .navbar-brand:hover, .navbar-default .navbar-brand:focus {
	color:#000;
	text-shadow: none;
}
.navbar-default .navbar-nav>.open>a, .navbar-default .navbar-nav>.open>a:hover, .navbar-default .navbar-nav>.open>a:focus {
	background-color: #fff;
}
.hd-dropdown-menu {
	background-color: rgba(76,121,90,0.8);
	border-bottom: 5px solid #fb8a08;
}
.hd-dropdown-menu>li>a {
	color: #fff;
	font-size: 12px;
}
</style>
<div class="container">
	<div class="main-header">
		<div class="inner-side">
			<nav class="navbar navbar-default navbar-fixed-top" style="background:#6a9277;border:0;">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="body">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="student/index.do">Bai Max</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<c:if test="${empty sessionScope.act_contact.email }">
						<li class="dropdown">
							<a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">我的课程
								<span class="caret"></span> </a>
							<ul class="dropdown-menu hd-dropdown-menu">
								<li>
									<a href="javascript:void(0)">正在学习 </a>
								</li>
								<li>
									<a href="javascript:void(0)">已完成课程</a>
								</li>
								<li role="separator" class="divider"></li>
								<li>
									<a href="javascript:void(0)">最近访问</a>
								</li>
							</ul>
						</li>
						</c:if>
						<li>
							<a href="lesson/filterlist.do?key=0">全部课程</a>
						</li>
						<li>
							<a href="javascript:void(0)">热播</a>
						</li>
						<li>
							<a href="javascript:void(0)">计算机</a>
						</li>
						<li>
							<a href="javascript:void(0)">艺术</a>
						</li>
						<li>
							<a href="javascript:void(0)">经济</a>
						</li>
						<li>
							<a href="javascript:void(0)">心理学</a>
						</li>
					</ul>
					<div class="navbar-right">
						<ul class="nav navbar-nav">
							<c:if test="${!empty sessionScope.act_contact.email }">
								<li class="dropdown">
									<a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown"
										role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.act_contact.email }
										<span class="caret"></span> </a>
									<ul class="dropdown-menu hd-dropdown-menu">
										<li>
											<a href="lesson/myStudyingLessons.do">正在学习</a>
										</li>
										<li>
											<a href="javascript:void(0)">已完成课程</a>
										</li>
										<li>
											<a href="javascript:void(0)">最近访问</a>
										</li>
										<li role="separator" class="divider"></li>
										<li>
											<a href="account/signout.do">注销登录</a>
										</li>
									</ul>
								</li>
							</c:if>
							<c:if test="${empty sessionScope.act_contact.email }">
								<li>
									<a href="login.jsp">登录</a>
								</li>
							</c:if>
							<li>
								<a href="act/reg.jsp">注册</a>
							</li>
						</ul>
					</div>
					<%--
					<form class="navbar-form navbar-right">
						<input type="text" class="form-control" placeholder="查找...">
					</form>
					--%>
				</div>
				<!--/.nav-collapse -->
			</div>
			</nav>
			<!-- navbar end -->
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<div class="social-icons" style="display: none">
	<a href="javascript:void(0)"><i class="icon1"></i> </a>
	<a href="javascript:void(0)"><i class="icon2"></i> </a>
	<a href="javascript:void(0)"><i class="icon3"></i> </a>
</div>
