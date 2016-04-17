<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form name="myform" action="teacher/addOperator.do" method="post">
	<div class="row">
		<div class="col-lg-2 text-right">
			<span class="control-pane">员工姓名</span>
		</div>
		<div class="col-lg-5">
			<input type="text" name="name" class="form-control" required />
		</div>
		<div class="col-lg-5">

		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			<span class="control-pane">手机号码</span>
		</div>
		<div class="col-lg-5">
			<input type="text" name="celphone" class="form-control" required />
		</div>
		<div class="col-lg-5">

		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			所属部门
		</div>
		<div class="col-lg-5">
			<input type="text" name="department" required class="form-control"
				placeholder="如：市场部" />
		</div>
		<div class="col-lg-5">

		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			职位
		</div>
		<div class="col-lg-5">
			<input type="text" name="post" required class="form-control"
				placeholder="如：市场部总监" />
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
			<button type="submit" class="btn btn-primary">
				保 存
			</button>
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<c:if test="${!empty status }">
		<div class="row">
			<div class="col-lg-12 alert alert-success">
				${status } 登陆账号：${username } 初始密码：${pwd }
			</div>
		</div>
	</c:if>
</form>