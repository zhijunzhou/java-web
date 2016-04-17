<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String pathOperTea = request.getContextPath();
String basePathOperTea = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathOperTea+"/";
%>
<base href="<%=basePathOperTea%>">
<div class="col-lg-6">
<form name="myform" action="teacher/operateTeacher.do" method="post">
	<div class="row">
		<div class="col-lg-2 text-right">
			<span class="control-pane">操作名</span>
		</div>
		<div class="col-lg-8">
			<select name="name" class="form-control">
				<option value="1">
					跟进
				</option>
				<option value="2">
					洽谈
				</option>
				<option value="3">
					签约
				</option>
			</select>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			细节描述
		</div>
		<div class="col-lg-8">
			<textarea rows="3" class="form-control" name="op_detail" required></textarea>
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
			<input type="hidden" value="${teacher_id }" name="teacher_id" />
			<button type="submit" class="btn btn-primary">
				更 新
			</button>
		</div>
	</div>
</form>
</div>
<div class="col-lg-6">
<table class="table table-bordered">
	<thead>
		<tr>
			<th>
				ID
			</th>
			<th>
				详情
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${operations }" var="op" varStatus="xh">
			<tr>
				<td>
					${xh.index + 1 }
				</td>
				<td>
					[${op[1] }]-[${op[2] }]-[${op[3] }]
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>