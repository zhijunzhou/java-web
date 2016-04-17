<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path3 = request.getContextPath();
	String basePath3 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path3 + "/";
%>
<base href="<%=basePath3%>" />
<!-- left menu tree -->
<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 visible-lg">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				目录
			</h3>
		</div>
		<div class="panel-body">
			<div class="navbar-collapse">
				<a href="javascript:void(0)"><i class="glyphicon glyphicon-play"></i>教师</a>
				<ul class="nav in">
					<li>
						<a href="teacher/newTeacher.jsp" data-toggle="collapse" data-target="#firstnav"> <span>添加老师</span> </a>

						<a href="teacher/list.do" data-toggle="collapse" data-target="#firstnav"> <span>老师列表</span> </a>
					</li>
				</ul>
				<a href="javascript:void(0)"><i class="glyphicon glyphicon-play"></i>课程</a>
				<ul class="nav in">
					<li>
						<a href="lesson/newLesson.jsp" data-toggle="collapse" data-target="#firstnav"> <span>添加课程</span> </a>

						<a href="lesson/filterlist.do" data-toggle="collapse" data-target="#firstnav"> <span>课程列表</span> </a>
						<a href="lesson/filterlist.do?rank=1" data-toggle="collapse" data-target="#firstnav"> <span>十佳最热课程</span> </a>
						<a href="lesson/filterlist.do?rank=2" data-toggle="collapse" data-target="#firstnav"> <span>点击量排名</span> </a>
					</li>
				</ul>
				<a href="javascript:void(0)"><i class="glyphicon glyphicon-play"></i>机构</a>
				<ul class="nav in">
					<li>
						<a href="organization/newTeacher.jsp" data-toggle="collapse" data-target="#firstnav"> <span>添加机构</span> </a>

						<a href="teacher/orgList.do" data-toggle="collapse" data-target="#firstnav"> <span>机构列表</span> </a>
					</li>
				</ul>
				<a href="javascript:void(0)"><i class="glyphicon glyphicon-play"></i>运营</a>
				<ul class="nav in">
					<li>
						<a href="teacher/getOperatorOperations.do" data-toggle="collapse" data-target="#firstnav"> <span>跟进历史</span> </a>
							</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- end left menu tree -->