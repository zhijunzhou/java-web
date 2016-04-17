<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String pathDetail = request.getContextPath();
String basePathDetail = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathDetail+"/";
%>
<base href="<%=basePathDetail%>">
<style>
.lesson-detail-img {
	height: 300px;
}
.lesson-detail-img {
	border: 1px solid #ccc;
}
.lesson-detail-msg .row {
	margin-bottom: 15px;
	font-size: 10;
	color:#666;
}
</style>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<div class="panel panel-default">
		<div class="panel-body">
			<%@include file="/lesson/component/lessonMessage.jsp" %>
			<%@include file="/lesson/component/_enrolledStudent.jsp" %>
		</div>
	</div>
</div>