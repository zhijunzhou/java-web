<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String pathNewLesson = request.getContextPath();
String basePathNewLesson = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathNewLesson+"/";
%>
<base href="<%=basePathNewLesson%>">
<script src="js/moment.js"></script>
<script src="js/datetimepicker.min.js"></script>
<form name="courseform" action="lesson/addLesson.do" method="post"
	enctype="multipart/form-data">
	<div class="row">
		<div class="col-lg-3">
			<span class="control-pane">课程名</span>
		</div>
		<div class="col-lg-5">
			<input type="text" name="lsn_name" class="form-control" required />
		</div>
		<div class="col-lg-4">

		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			课程概要
		</div>
		<div class="col-lg-5">
			<input type="text" name="summary" class="form-control" required />
		</div>
		<div class="col-lg-4">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			所属学科
		</div>
		<div class="col-lg-5">
			<select class="form-control" name="sbj_name">
				<option>
					语文
				</option>
				<option selected="selected">
					数学
				</option>
				<option>
					外语
				</option>
				<option>
					物理
				</option>
				<option>
					化学
				</option>
				<option>
					历史
				</option>
				<option>
					地理
				</option>
				<option>
					生物
				</option>
				<option>
					其它
				</option>
			</select>
		</div>
		<div class="col-lg-4">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			适用年级
		</div>
		<div class="col-lg-5">
			<select class="form-control" name="grade_value">
				<option value="1">
					小学
				</option>
				<option value="2">
					初中
				</option>
				<option value="3">
					高中
				</option>
				<option value="4">
					大专
				</option>
				<option value="5" selected>
					本科
				</option>
				<option value="10">
					其它
				</option>
			</select>
		</div>
		<div class="col-lg-4">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			课程类型
		</div>
		<div class="col-lg-5">
			<select class="form-control" name="lsn_type_name">
				<option value="1">
					公益课
				</option>
				<option value="2" selected="selected">
					线上公开课
				</option>
				<option value="3">
					一对一辅导
				</option>
				<option value="4">
					其它
				</option>
			</select>
		</div>
		<div class="col-lg-4">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			老师ID
		</div>
		<div class="col-lg-5">
			<input type="text" name="teacher_id" class="form-control" required />
		</div>
		<div class="col-lg-4 text-warning">
			<a href="teacher/list.do" target="_blank">教师列表</a>包含教师ID
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			授课时间
		</div>
		<div class="col-lg-5">
			<div class="col-lg-10 input-group">
				<input type="text" id="argmt_time" name="argmt_time"
					class="form-control" required />
				<span class="input-group-addon" id="basic-addon1"><i
					class="glyphicon glyphicon-calendar"></i>
				</span>
			</div>
		</div>
		<div class="col-lg-4">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			计划人数
		</div>
		<div class="col-lg-5">
			<input type="text" name="max_user" class="form-control" required />
		</div>
		<div class="col-lg-4">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			地址
		</div>
		<div class="col-lg-5">
			<input type="text" name="addr" class="form-control" required />
		</div>
		<div class="col-lg-4">

		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			价格
		</div>
		<div class="col-lg-5">
			<input type="text" name="price" class="form-control" required />
		</div>
		<div class="col-lg-4">

		</div>
	</div>
	<div class="row">
		<div class="col-lg-3">
			课程预览图
		</div>
		<div class="col-lg-5">
			<div class="col-lg-10 input-group">
				<input type="file" name="imgUrl" class="form-control"
					placeholder="选择本地图片文件...">
				<span class="input-group-addon" id="basic-addon1"><i
					class="glyphicon glyphicon-folder-open"></i> 浏览...</span>
			</div>
		</div>
		<div class="col-lg-4">

		</div>
	</div>
	<div class="row">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-4"></div>
		<div class="col-lg-2 col-md-4 col-sm-4 col-xs-4">
			<button type="reset" class="btn btn-default">
				撤 销
			</button>
		</div>
		<div class="col-lg-3 col-md- col-sm-4 col-xs-4">
			<button type="button" class="btn btn-primary" id="saveLesson">
				保 存
			</button>
		</div>
		<div class="col-lg-4">
		</div>
	</div>
</form>

<script type="text/javascript">
$(function(){
	$("#argmt_time").datetimepicker({
		format: "YYYY-MM-DD"
	});
	$("#saveLesson").click(function() {
		
		if(confirm('课程安排保存后将无法修改，确定提交吗？')) {
			document.courseform.submit();
		}
		
	});
});
</script>

