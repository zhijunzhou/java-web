<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%
	String path3 = request.getContextPath();
	String basePath3 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path3 + "/";
%>
<base href="<%=basePath3%>" />
<style>
.lesson-table-list {
	font-size: 10px;
}
</style>
<!-- left menu tree -->
<div class="col-lg-7 col-md-12 col-sm-12 col-xs-12">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				课程列表
			</h3>
		</div>
		<div class="panel-body">
			<div class="navbar-collapse">
				<!-- search -->
				<form name="searchform" action="lesson/filterlist.do" method="get">
					<div class="row form-inline">
						<div class="col-lg-8 input-group">
							<span class="input-group-addon" id="basic-addon2">按：<i
											class="glyphicon glyphicon-calendar"></i></span>
							<input type="text" name="startdate" required class="form-control date"
								placeholder="开始时间">
							<span class="input-group-addon" id="basic-addon3"><i
											class="glyphicon glyphicon-calendar"></i></span>
							<input type="text" name="enddate" required class="form-control date"
								placeholder="结束时间">
						</div>
						<div class="col-lg-3">
							<button class="btn btn-primary" id="basic-addon1" type="submit"><i
								class="glyphicon glyphicon-search"></i> 搜索课程</button>
						</div>
					</div>
				</form>
<script type="text/javascript">
$(function() {
	$(".date").datetimepicker({
		format: "YYYY-MM-DD"
	});
});
</script>
				<!-- end search -->
				<table class="table table-bordered lesson-table-list">
					<thead>
						<tr>
							<th>
								课程名
							</th>
							<th>
								适用年级
							</th>
							<th>
								课程主题
							</th>
							<th>
								课程分类
							</th>
							<th>
								授课时间
							</th>
							<th>
								主讲老师
							</th>
							<th>
								计划人数
							</th>
							<th>
								课程价格
							</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${list }" var="agt" varStatus="xh">
						<tr>
							<td>
								${agt[0]}
							</td>
							<td>
								${agt[1] }
							</td>
							<td>
								${agt[2]}
							</td>
							<td>
								${agt[3]}
							</td>
							<td>
								${agt[4] }
							</td>
							<td>
								${agt[5]}
							</td>
							<td>
								${agt[6]}
							</td>
							<td>
								${agt[7]}
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>
<!-- end left menu tree -->