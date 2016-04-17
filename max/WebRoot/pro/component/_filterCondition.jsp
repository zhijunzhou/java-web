<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String pathFilter = request.getContextPath();
	String basePathFilter = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathFilter + "/";
%>
<base href="<%=basePathFilter%>">

<div class="container">
	<ol class="breadcrumb">
		<li>
			<a href="#">主页</a>
		</li>
		<li class="active">
			全部课程
		</li>
	</ol>
</div>
<div class="row">
	<div class="col-md-2 text-right">
		学科分类：
	</div>
	<div class="col-md-10 text-condition">
		<input type="checkbox" class="" />
		&nbsp;语文
		<input type="checkbox" class="" />
		&nbsp;数学
		<input type="checkbox" class="" />
		&nbsp;英语
		<input type="checkbox" class="" />
		&nbsp;物理
		<input type="checkbox" class="" />
		&nbsp;化学
		<input type="checkbox" class="" />
		&nbsp;生物
		<input type="checkbox" class="" />
		&nbsp;政治
		<input type="checkbox" class="" />
		&nbsp;历史
		<input type="checkbox" class="" />
		&nbsp;地理
	</div>
</div>
<div class="row">
	<div class="col-md-2 text-right">
		专业分类：
	</div>
	<div class="col-md-10 text-condition">
		<input type="checkbox" class="" />
		&nbsp;计算机
		<input type="checkbox" class="" />
		&nbsp;外语
		<input type="checkbox" class="" />
		&nbsp;经济
		<input type="checkbox" class="" />
		&nbsp;建筑
		<input type="checkbox" class="" />
		&nbsp;艺术
		<input type="checkbox" class="" />
		&nbsp;人文
		<input type="checkbox" class="" />
		&nbsp;礼仪
	</div>
</div>
<div class="row">
	<div class="col-md-2 text-right">
		授课时间：
	</div>
	<div class="col-md-10">
		<input type="text" name="startdate" id="startdate" required
			class="date">
		~
		<input type="text" name="enddate" id="enddate" required class="date">
	</div>
</div>