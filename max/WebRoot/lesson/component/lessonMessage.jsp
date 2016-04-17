<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String pathMsg = request.getContextPath();
String basePathMsg = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathMsg+"/";
%>
<script type="text/javascript" src="js/requestApi.js"></script>
<base href="<%=basePathMsg%>">
<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
	<div class="lesson-detail-img"
		style="background: url('upload/lesson/${lessonArrangement.lesson.imgUrl}') center center"></div>
</div>
<div class="col-lg-7 col-md-5 col-sm-5 col-xs-5">
	<div class="lesson-detail-msg">
		<div class="row">
			<div class="col-lg-3">
				课程名：
			</div>
			<div class="col-lg-9">${lessonArrangement.lesson.title }</div>
		</div>
		<div class="row">
			<div class="col-lg-3">
				适用年级：
			</div>
			<div class="col-lg-9">${lessonArrangement.lesson.gradeCata.grade_name }</div>
		</div>
		<div class="row">
			<div class="col-lg-3">
				课程主题：
			</div>
			<div class="col-lg-9">${lessonArrangement.lesson.subject.name }</div>
		</div>
		<div class="row">
			<div class="col-lg-3">
				课程分类：
			</div>
			<div class="col-lg-9">${lessonArrangement.lessonType.name }</div>
		</div>
		<div class="row">
			<div class="col-lg-3">
				授课时间：
			</div>
			<div class="col-lg-9">${lessonArrangement.time }</div>
		</div>
		<div class="row">
			<div class="col-lg-3">
				主讲老师：
			</div>
			<div class="col-lg-9"><a href="teacher/viewTeacherById.do?teacher_id=${lessonArrangement.teacher.id }">${lessonArrangement.teacher.id }</a></div>
		</div>
		<div class="row">
			<div class="col-lg-3">
				注册/计划：
			</div>
			<div class="col-lg-9"><span class="text-red">${lessonArrangement.enroll_num}</span>/${lessonArrangement.max_user }</div>
		</div>
		<div class="row">
			<div class="col-lg-3">
				课程价格：
			</div>
			<div class="col-lg-9">￥${lessonArrangement.price }</div>
		</div>
		<div class="row">
			<div class="col-lg-3">
				直播网址：
			</div>
			<div class="col-lg-9">
				<a href="lesson/playVideo.do?addr=${lessonArrangement.addr }">${lessonArrangement.addr }</a>
				<c:if test="${!empty sessionScope.operator_id }">
				<a data-toggle="modal" data-target="#mod"><i class="glyphicon glyphicon-edit"></i></a>
				<form name="videoform" action="lesson/uploadVideo.do" method="post" enctype="multipart/form-data">
				<div class="modal fade" id="mod" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">上传视频</h4>
				      </div>
				      <div class="modal-body">
				        <div class="col-lg-10 input-group">
							<input type="file" name="addr" class="form-control"
								placeholder="选择本地MP4视频文件...">
							<span class="input-group-addon" id="basic-addon1"><i
								class="glyphicon glyphicon-folder-open"></i> 浏览...</span>
						</div>
				      </div>
				      <div class="modal-footer">
				      	<input type="hidden" name="lesson_arrangement_id" value="${lessonArrangement.id }" />
				        <button type="reset" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="submit" class="btn btn-primary">上传</button>
				      </div>
				    </div>
				  </div>
				</div>
				</form>
				</c:if>
			</div>
		</div>
		<c:if test="${!empty sessionScope.operator_id }">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
				<c:if test="${lessonArrangement.lesson_status == -1 }">
					<a class="btn btn-primary" id="startlesson">开始课程</a>
				</c:if>
				<c:if test="${lessonArrangement.lesson_status == 0 }">
					<a class="btn btn-danger" id="endlesson">结束课程</a>
				</c:if>
				<c:if test="${lessonArrangement.lesson_status == 1 }">
					该课程已结束！
				</c:if>
			</div>
			<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"></div>
		</c:if>
		<c:if test="${empty sessionScope.operator_id }">
		<c:if test="${empty sessionScope.act_contact.email }">
		<div class="row">
			<div class="col-md-12 text-danger">要加入该课程，请先用学生账号登录！</div>
		</div>
		</c:if>
		<c:if test="${(!empty sessionScope.act_contact) }">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
			<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
				<a class="btn btn-warning">收藏</a>
			</div>
			<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
				<a class="btn btn-primary" id="joinLesson">我要加入</a>
			</div>
		</div>
		<div class="row">
			<div class="text-warning">注：若该课程有直播，直播频道请参见下面评论！</div>
		</div>
		</c:if>
		</c:if>
	</div>
</div>
<input type="hidden" id="lesson_arrangement_id" name="lesson_arrangement_id" value="${lessonArrangement.id }" />