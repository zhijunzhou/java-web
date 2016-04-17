<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String hotpath = request.getContextPath();
String hotbasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+hotpath+"/";
%>
<base href="<%=hotbasePath%>">
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
			最热课程
		</h3>
	</div>
	<div class="panel-body">
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
			<div class="course-hotest-item">
				<div class="course-hotest-img"
					style="background: url('upload/lesson/${hotest[0][11]}') center center">
					<div class="course-description">
						￥${hotest[0][8] }
					</div>
				</div>
				<div class="course-title">
					<a href="lesson/detail.do?lesson_arrangement_id=${hotest[0][0]}">${hotest[0][1] }</a>
				</div>
				<div class="course-clicknum">
					${hotest[0][9] }次
				</div>
			</div>
		</div>
		<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
			<div class="row" style="margin-bottom: 10px;">
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
					<div class="course-item">
						<div class="course-img" style="background: url('upload/lesson/${hotest[1][11]}') center center">
							<div class="course-description">
								￥${hotest[1][8] }
							</div>
						</div>
						<div class="course-title">
							<a href="lesson/detail.do?lesson_arrangement_id=${hotest[1][0]}">${hotest[1][1] }</a>
						</div>
						<div class="course-clicknum">
							${hotest[1][9] }次
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
					<div class="course-item">
						<div class="course-img" style="background: url('upload/lesson/${hotest[2][11]}') center center">
							<div class="course-description">
								￥${hotest[2][8] }
							</div>
						</div>
						<div class="course-title">
							<a href="lesson/detail.do?lesson_arrangement_id=${hotest[2][0]}">${hotest[2][1] }</a>
						</div>
						<div class="course-clicknum">
							${hotest[2][9] }次
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
					<div class="course-item">
						<div class="course-img" style="background: url('upload/lesson/${hotest[3][11]}') center center">
							<div class="course-description">
								￥${hotest[3][8] }
							</div>
						</div>
						<div class="course-title">
							<a href="lesson/detail.do?lesson_arrangement_id=${hotest[3][0]}">${hotest[3][1] }</a>
						</div>
						<div class="course-clicknum">
							${hotest[3][9] }次
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
					<div class="course-item">
						<div class="course-img" style="background: url('upload/lesson/${hotest[4][11]}') center center">
							<div class="course-description">
								￥${hotest[4][8] }
							</div>
						</div>
						<div class="course-title">
							<a href="lesson/detail.do?lesson_arrangement_id=${hotest[4][0]}">${hotest[4][1] }</a>
						</div>
						<div class="course-clicknum">
							${hotest[4][9] }次
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
					<div class="course-item">
						<div class="course-img" style="background: url('upload/lesson/${hotest[5][11]}') center center">
							<div class="course-description">
								￥${hotest[5][8] }
							</div>
						</div>
						<div class="course-title">
							<a href="lesson/detail.do?lesson_arrangement_id=${hotest[5][0]}">${hotest[5][1] }</a>
						</div>
						<div class="course-clicknum">
							${hotest[5][9] }次
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
					<div class="course-item">
						<div class="course-img" style="background: url('upload/lesson/${hotest[6][11]}') center center">
							<div class="course-description">
								￥${hotest[6][8] }
							</div>
						</div>
						<div class="course-title">
							<a href="lesson/detail.do?lesson_arrangement_id=${hotest[6][0]}">${hotest[6][1] }</a>
						</div>
						<div class="course-clicknum">
							${hotest[6][9] }次
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

