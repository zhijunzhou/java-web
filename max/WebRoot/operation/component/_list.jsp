<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String pathOperList = request.getContextPath();
String basePathOperList = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathOperList+"/";
%>
<base href="<%=basePathOperList%>">
<!-- search -->
	<div class="col-lg-11 input-group">
		<input type="text" class="form-control"
			placeholder="输入机构简称、联系电话或ID进行搜索...">
		<span class="input-group-addon btn" id="basic-addon1"><i
			class="glyphicon glyphicon-search"></i> 搜索</span>
	</div>
<!-- end search -->

<hr />
<table class="table table-bordered">
	<thead>
		<tr>
			<th></th>
			<th>
				机构或老师名称
			</th>
			<th>
				操作时间
			</th>
			<th>
				业务操作名
			</th>
			<th>
				联系电话
			</th>
			<th>
				备注
			</th>
			<th>
				详情
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${operations }" var="opt" varStatus="xh">
			<tr>
				<td>
					${xh.index + 1 }
				</td>
				<td>
					${opt[0] }
				</td>
				<td>
					${opt[1] }
				</td>
				<td>
					${opt[2] }
				</td>
				<td>
					${opt[3] }
				</td>
				<td>
					${opt[4] }
				</td>
				<td>
					<a href="javascript:void(0)"><i
						class="glyphicon glyphicon-search"></i>
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
