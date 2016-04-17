<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String pathIng = request.getContextPath();
String basePathIng = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathIng+"/";
%>
<base href="<%=basePathIng%>">
<style>
.course-hotest-item {
	height:250px;
	border:1px solid #ccc;
}
.course-hotest-img {
	height:250px;
	padding:230px 0 10px 0;
}
.course-item {
	height:140px;
}
.course-img {
	padding:80px 0 10px 0;
	border-top:1px solid #111;
	height:100px;
	border:1px solid #ccc;
}
.course-description {
	color:#fff;
	padding: 0 8px;
	background: rgba(102,102,102,0.8);
}
.course-title {
	margin-top:6px;
	font-size:12px;
}
.course-title a {
	color:#333;
}
.course-clicknum {
	font-size: 8px;
	background: url("img/viewCountIcon.png") no-repeat left center;
	padding-left:16px;
}
</style>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">
			学习 ing
		</h3>
	</div>
	<div class="panel-body">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="row" style="margin-bottom: 10px;">
				<c:if test="${empty studyList }">
					该学生未当前未注册任何课程！
				</c:if>
				<c:forEach items="${studyList }" var="sdy">
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
						<div class="course-item">
							<div class="course-img" style="background: url('upload/lesson/${sdy.lessonArrangement.lesson.imgUrl}') center center">
								<div class="course-description">
									￥${sdy.lessonArrangement.price }
								</div>
							</div>
							<div class="course-title">
								<a href="lesson/detail.do?lesson_arrangement_id=${sdy.lessonArrangement.id }">${sdy.lessonArrangement.lesson.title }</a>
							</div>
							<div class="course-clicknum">
								${sdy.lessonArrangement.click_num }次
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>



