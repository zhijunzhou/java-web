<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String pathFilterLesson = request.getContextPath();
String basePathFilterLesson = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathFilterLesson+"/";
%>
<base href="<%=basePathFilterLesson%>">

<div class="col-md-12">
${list }
	<c:forEach items="${list }" var="agt">
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
			<div class="course-hotest-item">
				<div class="course-hotest-img"
					style="background: url('upload/lesson/${agt[11] }') center center">
					<div class="course-description">
						￥${agt[8] }
					</div>
				</div>
				<div class="course-title">
					<a href="lesson/detail.do?lesson_arrangement_id=${agt[0] }">${agt[1] }</a>
				</div>
				<div class="course-clicknum">
					${agt[10] }次
				</div>
			</div>
		</div>
	</c:forEach>
</div>
  