<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String pathTeaTab = request.getContextPath();
	String basePathTeaTab = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathTeaTab + "/";
%>
<base href="<%=basePathTeaTab%>">

<table class="table table-bordered">
	<thead>
		<tr>
			<th>
				老师ID
			</th>
			<th>
				操作
			</th>
			<th>
				姓名
			</th>
			<th>
				手机
			</th>
			<th>
				所属单位
			</th>
			<th>
				状态
			</th>
			<th class="text-center">
				最新跟进
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${teachers }" var="tc" varStatus="xh">
			<tr>
				<td>
					${tc[0] }
				</td>
				<td>
					<a
						href="teacher/updatingTeacher.do?teacher_id=${tc[0] }&account_id=${tc[1] }&contact_id=${tc[2] }&identity_id=${tc[3]}&misc_id=${tc[4]}">编辑资料</a>
					<a href="teacher/operatingTeacher.do?teacher_id=${tc[0] }">跟进</a>
				</td>
				<td>
					<a
						href="teacher/viewTeacher.do?teacher_id=${tc[0] }&account_id=${tc[1] }&contact_id=${tc[2] }&identity_id=${tc[3]}&misc_id=${tc[4]}">${tc[5]
						}</a>
				</td>
				<td>
					${tc[6] }
				</td>
				<td>
					${tc[7] }
				</td>
				<td>
					${tc[8] }
				</td>
				<td class="text-center">
					[${tc[10] }]-[${tc[11] }]-[${tc[12] }]
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
