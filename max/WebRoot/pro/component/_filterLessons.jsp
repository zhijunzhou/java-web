<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String pathFilterLesson = request.getContextPath();
	String basePathFilterLesson = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathFilterLesson + "/";
%>
<base href="<%=basePathFilterLesson%>">
<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				课程搜索结果：共 ${fn:length(list)} 条记录
			</h3>
		</div>
		<div class="panel-body">
			<div class="col-md-12">
				<c:forEach items="${list }" var="agt">
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
						<div class="course-item">
							<div class="course-img"
								style="background: url('upload/lesson/${agt[11] }') center center">
								<div class="course-description">
									￥${agt[8] }
								</div>
							</div>
							<div class="course-title">
								<a href="lesson/detail.do?lesson_arrangement_id=${agt[0] }">${agt[1]
									}</a>
							</div>
							<div class="course-clicknum">
								${agt[10] }次
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
