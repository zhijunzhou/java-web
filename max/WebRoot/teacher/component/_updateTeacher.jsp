<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String pathUpdateTea = request.getContextPath();
String basePathUpdateTea = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathUpdateTea+"/";
%>
<base href="<%=basePathUpdateTea%>">
<link href="css/datetimepicker.min.css" rel="stylesheet" />
<script src="js/moment.js"></script>
<script src="js/datetimepicker.min.js"></script>
<form name="myform" action="teacher/updateTeacher.do" method="post"
	enctype="multipart/form-data">
	<div class="row">
		<div class="col-lg-2 text-right">
			<span class="control-pane">教师姓名</span>
		</div>
		<div class="col-lg-5">
			<input type="text" class="form-control" name="name"
				value="${identity.name }" />
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			教师照片
		</div>
		<div class="col-lg-5">
			<div class="col-lg-10 input-group">
				<input type="file" name="avatar_url" class="form-control"
					placeholder="选择本地图片文件..." value="${misc.avatar_url }">
				<span class="input-group-addon" id="basic-addon1"><i
					class="glyphicon glyphicon-folder-open"></i> 浏览...</span>
			</div>
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			注册日期
		</div>
		<div class="col-lg-5">
			<input type="text" name="" class="form-control"
				value="${account.reg_time }" readonly />
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			手机号码
		</div>
		<div class="col-lg-5">
			<input type="text" name="celphone" class="form-control"
				value="${contact.celphone }" placeholder="如：18012345678" />
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			教师生日
		</div>
		<div class="col-lg-5">
			<div class="col-lg-10 input-group">
				<input type="text" id="birthday" value="${identity.birthday}"
					name="birthday" class="form-control">
				<span class="input-group-addon" id="basic-addon1"><i
					class="glyphicon glyphicon-calendar"></i> </span>
			</div>
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			所在区域
		</div>
		<div class="col-lg-5">
			<input type="text" name="loc_id" class="form-control"
				value="${contact.loc_id }" placeholder="如：湖北省武汉市" />
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			所属单位
		</div>
		<div class="col-lg-5">
			<input type="text" name="org_name" class="form-control"
				value="${teacher.organization.name }" placeholder="如：中国工商银行武汉分行" />
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			单位属性
		</div>
		<div class="col-lg-5">
			<select class="form-control" name="org_type">
				<option value="1"
					<c:if test="${teacher.organization.org_type.id == 1 }">selected</c:if>>
					公立学校
				</option>
				<option value="2"
					<c:if test="${teacher.organization.org_type.id == 2 }">selected</c:if>>
					民办学校
				</option>
				<option value="3"
					<c:if test="${teacher.organization.org_type.id == 3 }">selected</c:if>>
					培训机构
				</option>
				<option value="4"
					<c:if test="${teacher.organization.org_type.id == 4 }">selected</c:if>>
					独立教师
				</option>
			</select>
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			签约状态
		</div>
		<div class="col-lg-5">
			<select class="form-control" name="mgt_status_id">
				<option value="1"
					<c:if test="${teacher.managementStatus.id == 1 }">selected</c:if>>
					已聘
				</option>
				<option value="2"
					<c:if test="${teacher.managementStatus.id == 2 }">selected</c:if>>
					待聘
				</option>
				<option value="3"
					<c:if test="${teacher.managementStatus.id == 3 }">selected</c:if>>
					解聘
				</option>
				<option value="4"
					<c:if test="${teacher.managementStatus.id == 4 }">selected</c:if>>
					已签约
				</option>
			</select>
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			教师标签
		</div>
		<div class="col-lg-5">
			未开放功能
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right"></div>
		<div class="col-lg-2">
			<button type="reset" class="btn btn-default">
				撤 销
			</button>
		</div>
		<div class="col-lg-3">
			<input type="hidden" value="${teacher.id }" name="teacher_id" />
			<input type="hidden" value="${contact.id }" name="contact_id" />
			<input type="hidden" value="${identity.id }" name="identity_id" />
			<input type="hidden" value="${misc.id }" name="misc_id" />
			<button type="submit" class="btn btn-primary">
				更 新
			</button>
		</div>
		<div class="col-lg-5">
		</div>
	</div>
</form>