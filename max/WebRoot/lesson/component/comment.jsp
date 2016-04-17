<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String pathComment = request.getContextPath();
String basePathComment = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathComment+"/";
%>
<base href="<%=basePathComment%>">
<style>
.comment-divider {
	width: 100%;
}
.comment-container {
	font-size: 12px;
}
.comment-floor {
	border-bottom:1px solide #ccc;
}
.comment-content {
	padding:20px;
	font-size: 12px;
}
.comment-core{
	min-height: 60px;
	border-bottom: 1 solid #bbb;
	padding:20px;
}
blockquote {
	border-left:3px solid #00ee00;	
}
</style>
<div class="col-lg-12">
	<div class="row">
		<hr class="comment-divider" />
		<div class="col-1g-12"><h5>&raquo;课程评论</h5></div>
	</div>
	<div class="row">
		<form name="commentForm" action="lesson/addComment.do" method="POST">
			<div class="col-lg-12">
				<textarea class="form-control" name="content" row="5" required></textarea>
			</div>
			<div class="col-lg-12 text-right pull-right" style="margin-top:10px;">
				<input type="hidden" name="lesson_arrangement_id" value="${lessonArrangement.id }" />
				<input type="submit" class="btn btn-primary" value="评论" />
			</div>
		</form>
	</div>
</div>
<div class="col-lg-12 comment-container">
	<div class="row">
		<hr class="comment-divider" />
		<div class="col-1g-12"><h5>&raquo;历史评论</h5></div>
	</div>
	<c:forEach items="${comments }" var="tc"  varStatus="xh">
		<div class="colg-lg-12 comment-core">
			<blockquote>
				<span class="comment-usr"><i class="glyphicon glyphicon-user"></i></span>
				<span class="comment-content">${tc.content }</span>
			</blockquote>
		</div>	
	</c:forEach>	
</div>