<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- search -->
<form name="searchform" action="teacher/filterlist.do" method="post">
		<div class="col-lg-10 input-group">
			<input type="text" name="param" class="form-control"
				placeholder="可根据学生ID，手机号以及姓名进行搜索...">
			<span class="input-group-addon btn" id="basic-addon1"><i
				class="glyphicon glyphicon-search"></i> 搜索</span>
		</div>
</form>
<!-- end search -->
<hr />

<hr />
<table class="table table-bordered">
	<thead>
		<tr>
			<th>
				学生ID
			</th>
			<th>
				姓名
			</th>
			<th>
				别名
			</th>
			<th>
				手机号
			</th>
			<th>
				注册时间
			</th>
			<th>
				邮箱
			</th>
			<th class="text-center">

			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="tc" varStatus="xh">
			<tr>

				<td>
					${tc[0] }
				</td>
				<td>
					${tc[1] }
				</td>
				<td>
					${tc[2] }
				</td>
				<td>
					${tc[3] }
				</td>
				<td>
					${tc[4] }
				</td>
				<td>
					${tc[5] }
				</td>
				<td class="text-center">

				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>