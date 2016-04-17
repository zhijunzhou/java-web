<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%
String pathList = request.getContextPath();
String basePathList = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathList+"/";
%>
<base href="<%=basePathList%>">
<script src="js/moment.js"></script>
<script src="js/datetimepicker.min.js"></script>
<!-- search -->
<form name="searchform" action="lesson/filterlist.do" method="get">
	<div class="row form-inline">
		<div class="col-lg-8 input-group">
			<span class="input-group-addon">按：<i
				class="glyphicon glyphicon-calendar"></i> </span>
			<input type="text" name="startdate" id="startdate" required
				class="form-control date" placeholder="开始时间">
			<span class="input-group-addon"><i
				class="glyphicon glyphicon-calendar"></i> </span>
			<input type="text" name="enddate" id="enddate" required
				class="form-control date" placeholder="结束时间">
		</div>
		<div class="col-lg-3">
			<button class="btn btn-primary" id="basic-addon1" type="submit">
				<i class="glyphicon glyphicon-search"></i> 搜索课程
			</button>
		</div>
	</div>
</form>
<table class="table table-bordered lesson-table-list">
	<thead>
		<tr>
			<th>
				ID
			</th>
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
			<th>
				访问次数
			</th>
			<th>
				注册人数
			</th>
			<th>
				预览图片
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="agt" varStatus="xh">
			<tr>
				<td>
					${agt[0] }
				</td>
				<c:if test="${agt[12] == 1 }">
					<td style="background: url('img/completed.png')">
				</c:if>
				<c:if test="${agt[12] != 1 }">
					<td>
				</c:if>
					<a href="lesson/lessonDetail.do?lesson_arrangement_id=${agt[0] }">${agt[1]
						}</a>
				</td>
				<td>
					${agt[2] }
				</td>
				<td>
					${agt[3] }
				</td>
				<td>
					${agt[4] }
				</td>
				<td>
					${agt[5] }
				</td>
				<td>
					${agt[6] }
				</td>
				<td>
					${agt[7] }
				</td>
				<td>
					${agt[8] }
				</td>
				<td>
					${agt[9] }
				</td>
				<td>
					${agt[10] }
				</td>
				<td>
					<img src="upload/lesson/${agt[11] }" width="32" />
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- begin hot course -->
<%@include file="/lesson/component/hotest.jsp"%>
<!-- end hot course -->
<script type="text/javascript">
				$(function() {
					$("#startdate").datetimepicker({
						format: "YYYY-MM-DD"
					});
				});
				$(function() {
					$("#enddate").datetimepicker({
						format: "YYYY-MM-DD"
					});
				});
</script>
