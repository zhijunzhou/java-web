<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String pathLeftMenu = request.getContextPath();
String basePathLeftMenu = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathLeftMenu+"/";
%>
<base href="<%=basePathLeftMenu%>">
<%String sid =request.getParameter("sid"); %>
<!-- Left side column. contains the sidebar -->
<aside class="main-sidebar">
<!-- sidebar: style can be found in sidebar.less -->
<section class="sidebar">
<!-- Sidebar user panel -->
<div class="user-panel">
	<div class="pull-left image">
		<img src="img/user2-160x160.jpg" class="img-circle" alt="User Image">
	</div>
	<div class="pull-left info">
		<p>
			${sessionScope.operator }
		</p>
	</div>
</div>
<!-- search form -->
<form action="javascript::" method="get" class="sidebar-form">
	<div class="input-group">
		<input type="text" name="q" class="form-control" placeholder="搜索...">
		<span class="input-group-btn">
			<button type="button" name="search" id="search-btn"
				class="btn btn-flat">
				<i class="glyphicon glyphicon-search"></i>
			</button> </span>
	</div>
</form>
<!-- /.search form -->
<!-- sidebar menu: : style can be found in sidebar.less -->
<ul class="sidebar-menu">
	<li class="header">
		功能导航
	</li>
	<li class="treeview">
		<a href="#"> <i class="glyphicon glyphicon-user"></i> <span>老师</span>
			<i class="fa fa-angle-left pull-right"></i> </a>
		<ul class="treeview-menu" <% if(sid != null && sid.equals("02")) { %>
			style="display: block;" <%} %>>
			<li>
				<a href="teacher/newTeacher.jsp?sid=02"><i
					class="glyphicon glyphicon-plus"></i> 新建</a>
			</li>
			<li>
				<a href="teacher/list.do?sid=02"><i
					class="glyphicon glyphicon-map-marker"></i> 老师记录</a>
			</li>
		</ul>
	</li>
	<li class="treeview">
		<a href="#"> <i class="glyphicon glyphicon-tasks"></i> <span>课程</span>
			<i class="fa fa-angle-left pull-right"></i> </a>
		<ul class="treeview-menu" <% if(sid != null && sid.equals("03")) { %>
			style="display: block;" <%} %>>
			<li>
				<a href="lesson/newLesson.jsp?sid=03"><i
					class="glyphicon glyphicon-plus"></i> 新建</a>
			</li>
			<li>
				<a href="lesson/filterlist.do?sid=03&status=0"><i
					class="glyphicon glyphicon-map-marker"></i> 正在进行的课程</a>
			</li>
			<li>
				<a href="lesson/filterlist.do?rank=1&sid=03&status=-1"><i
					class="glyphicon glyphicon-map-marker"></i> 等待开始的课程</a>
			</li>
			<li>
				<a href="lesson/filterlist.do?rank=2&sid=03&status=1"><i
					class="glyphicon glyphicon-map-marker"></i> 已结束的课程</a>
			</li>
		</ul>
	</li>
	<li class="treeview">
		<a href="#"> <i class="glyphicon glyphicon-briefcase"></i> <span>机构</span>
			<i class="fa fa-angle-left pull-right"></i> </a>
		<ul class="treeview-menu" <% if(sid != null && sid.equals("04")) { %>
			style="display: block;" <%} %>>
			<li>
				<a href="organization/newTeacher.jsp?sid=04"><i
					class="glyphicon glyphicon-plus"></i> 新建</a>
			</li>
			<li>
				<a href="teacher/orgList.do?sid=04"><i
					class="glyphicon glyphicon-map-marker"></i> 机构列表</a>
			</li>
		</ul>
	</li>
	<li class="treeview">
		<a href="#"> <i class="glyphicon glyphicon-retweet"></i> <span>运营</span>
			<i class="fa fa-angle-left pull-right"></i> </a>
		<ul class="treeview-menu" <% if(sid != null && sid.equals("05")) { %>
			style="display: block;" <%} %>>
			<c:if test="${sessionScope.operator_id == 1 }">
				<li>
					<a href="teacher/newOperator.do?sid=05"><i
						class="glyphicon glyphicon-plus"></i> 新增业务员</a>
				</li>
			</c:if>
			<li>
				<a href="teacher/getOperatorOperations.do?sid=05"><i
					class="glyphicon glyphicon-map-marker"></i> 历史记录</a>
			</li>
		</ul>
	</li>
	<li class="treeview">
		<a href="#"> <i class="glyphicon glyphicon-education"></i> <span>学生</span>
			<i class="fa fa-angle-left pull-right"></i> </a>
		<ul class="treeview-menu" <% if(sid != null && sid.equals("06")) { %>
			style="display: block;" <%} %>>
			<li>
				<a href="act/reg.jsp?sid=06"><i class="glyphicon glyphicon-plus"></i>
					新增</a>
			</li>
			<li>
				<a href="student/list.do?sid=06"><i
					class="glyphicon glyphicon-map-marker"></i> 学生列表</a>
			</li>
			<li>
				<a href="javascript::"><i class="glyphicon glyphicon-log-in"></i>
					导入</a>
			</li>
			<li>
				<a href="javascript::"><i class="glyphicon glyphicon-log-out"></i>
					导出</a>
			</li>
		</ul>
	</li>
	<li class="treeview">
		<a href="#"> <i class="glyphicon glyphicon-tags"></i> <span>任务</span>
			<i class="fa fa-angle-left pull-right"></i> </a>
		<ul class="treeview-menu" <% if(sid != null && sid.equals("07")) { %>
			style="display: block;" <%} %>>
			<li>
				<a href="javascript::"><i class="glyphicon glyphicon-cog"></i>
					设定</a>
			</li>
			<li>
				<a href="javascript::"><i
					class="glyphicon glyphicon-map-marker"></i> 当前任务</a>
			</li>
			<li>
				<a href="javascript::"><i class="glyphicon glyphicon-ok"></i>
					已完成任务</a>
			</li>
		</ul>
	</li>
</ul>
</section>
<!-- /.sidebar -->
</aside>