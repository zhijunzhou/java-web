<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="col-lg-11">
	<form name="courseform" action="account/modifyPwd.do" method="post">
		<div class="row">
			<div class="col-lg-2">
				密码
			</div>
			<div class="col-lg-3">
				<input type="password" name="pwd1" required class="form-control" />
			</div>
			<div class="col-lg-7">

			</div>
		</div>
		<div class="row">
			<div class="col-lg-2">
				确认密码
			</div>
			<div class="col-lg-3">
				<input type="password" name="pwd2" required class="form-control" />
			</div>
			<div class="col-lg-7">

			</div>
		</div>
		<div class="row">
			<div class="col-lg-2">

			</div>
			<div class="col-lg-2">
				<input type="submit" class="btn" value="取消" />
			</div>
			<div class="col-lg-2">
				<input type="submit" class="btn btn-primary" value="确认" />
			</div>
			<div class="col-lg-6">

			</div>
		</div>
	</form>
</div>