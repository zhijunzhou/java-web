<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String pathViewTea = request.getContextPath();
String basePathViewTea = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathViewTea+"/";
%>
<base href="<%=basePathViewTea%>">
<script src="js/ichart.1.2.1.min.js"></script>
<div class="col-md-3">
	<!-- Profile Image -->
	<div class="box box-primary">
		<div class="box-body box-profile">
			<img class="profile-user-img img-responsive img-circle"
				src="${'upload/' }${misc.avatar_url}" alt="User profile picture">

			<h3 class="profile-username text-center">
				${identity.name }
			</h3>

			<p class="text-muted text-center">
				Tel: ${contact.celphone }
			</p>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
	<div class="row">
		<div class="col-lg-6 text-right">
			注册日期
		</div>
		<div class="col-lg-6">
			${account.reg_time }
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6 text-right">
			手机号码
		</div>
		<div class="col-lg-6">
			${contact.celphone }
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6 text-right">
			教师生日
		</div>
		<div class="col-lg-6">
			${identity.birthday}
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6 text-right">
			所在区域
		</div>
		<div class="col-lg-6">
			${contact.loc_id }
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6 text-right">
			所属单位
		</div>
		<div class="col-lg-6">
			${teacher.organization.name }
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6 text-right">
			单位属性
		</div>
		<div class="col-lg-6">
			${teacher.organization.org_type.title }
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6 text-right">
			教师标签
		</div>
		<div class="col-lg-6">
			未开放功能
		</div>
	</div>
</div>
<div class="col-md-8">
	<!-- graphics -->
	<table class="table table-bordered hidden" id="dataTable1">
		<c:forEach items="${data1 }" var="dt">
			<tr>
				<td>
					${dt[0] }
				</td>
				<td>
					${dt[1] }
				</td>
			</tr>
		</c:forEach>
	</table>
	<table class="table table-bordered hidden" id="dataTable2">
		<c:forEach items="${data2 }" var="dt">
			<tr>
				<td>
					${dt[0] }
				</td>
				<td>
					${dt[1] }
				</td>
			</tr>
		</c:forEach>
	</table>
	<table class="table table-bordered hidden" id="dataTable3">
		<c:forEach items="${data3 }" var="dt">
			<tr>
				<td>
					${dt[0] }
				</td>
				<td>
					${dt[1] }
				</td>
			</tr>
		</c:forEach>
	</table>
	<table class="table table-bordered hidden" id="dataTable4">
		<c:forEach items="${data4 }" var="dt">
			<tr>
				<td>
					${dt[0] }
				</td>
				<td>
					${dt[1] }
				</td>
			</tr>
		</c:forEach>
	</table>
	<div id='canvasDiv1'></div>
	<div id='canvasDiv2'></div>
	<div id='canvasDiv3'></div>
	<div id='canvasDiv4'></div>
	<!-- end graphics -->
</div>

<script type="text/javascript">
	var colors = [ '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc', '#d2d6de',
			'#00a65a', '#f39c12', '#00c0ef', '#76a871', '#d2d6de' ];

	var data1 = [];
	var data2 = [];
	var data3 = [];
	var data4 = [];
	$(function() {
		var dataTable1 = $("#dataTable1");
		var dataTable2 = $("#dataTable2");
		var dataTable3 = $("#dataTable3");
		var dataTable4 = $("#dataTable4");
		var tempDate1, tempDate2, tempDate3, tempDate4;
		$("#dataTable1 tr td").each(function(m, n) {
			if (m % 2 == 0) {
				tempDate1 = $(this).text();
			} else {
				var cl = colors[m % 10];
				data1.push({
					name : tempDate1,
					value : parseInt($(this).text(), 10),
					color : cl
				});
				tempDate1 = "";
			}
		});
		$("#dataTable2 tr td").each(function(m, n) {
			if (m % 2 == 0) {
				tempDate2 = $(this).text();
			} else {
				var cl = colors[m % 10];
				data2.push({
					name : tempDate2,
					value : parseInt($(this).text(), 10),
					color : cl
				});
				tempDate2 = "";
			}
		});
		$("#dataTable3 tr td").each(function(m, n) {
			if (m % 2 == 0) {
				tempDate3 = $(this).text();
			} else {
				var cl = colors[m % 10];
				data3.push({
					name : tempDate3,
					value : parseInt($(this).text(), 10),
					color : cl
				});
				tempDate3 = "";
			}
		});
		$("#dataTable4 tr td").each(function(m, n) {
			if (m % 2 == 0) {
				tempDate4 = $(this).text();
			} else {
				var cl = colors[m % 10];
				data4.push({
					name : tempDate4,
					value : parseInt($(this).text(), 10),
					color : cl
				});
				tempDate4 = "";
			}
		});
		var chart1 = new iChart.Column2D({
			render : 'canvasDiv1',//渲染的Dom目标,canvasDiv为Dom的ID
			data : data1,//绑定数据
			title : '公益课授课统计报表（图）',//设置标题
			width : 800,//设置宽度，默认单位为px
			height : 400,//设置高度，默认单位为px
			shadow : true,//激活阴影
			shadow_color : '#c7c7c7',//设置阴影颜色
			coordinate : {//配置自定义坐标轴
				scale : [ {//配置自定义值轴
					position : 'left',//配置左值轴	
					start_scale : 0,//设置开始刻度为0
					end_scale : 10,//设置结束刻度为26
					scale_space : 2,//设置刻度间距
					listeners : {//配置事件
						parseText : function(t, x, y) {//设置解析值轴文本
							return {
								text : t + " T"
							}
						}
					}
				} ]
			}
		});
		var chart2 = new iChart.Column2D({
			render : 'canvasDiv2',//渲染的Dom目标,canvasDiv为Dom的ID
			data : data2,//绑定数据
			title : '在线答疑授课统计报表（图）',//设置标题
			width : 800,//设置宽度，默认单位为px
			height : 400,//设置高度，默认单位为px
			shadow : true,//激活阴影
			shadow_color : '#c7c7c7',//设置阴影颜色
			coordinate : {//配置自定义坐标轴
				scale : [ {//配置自定义值轴
					position : 'left',//配置左值轴	
					start_scale : 0,//设置开始刻度为0
					end_scale : 10,//设置结束刻度为26
					scale_space : 2,//设置刻度间距
					listeners : {//配置事件
						parseText : function(t, x, y) {//设置解析值轴文本
							return {
								text : t + " T"
							}
						}
					}
				} ]
			}
		});
		var chart3 = new iChart.Column2D({
			render : 'canvasDiv3',//渲染的Dom目标,canvasDiv为Dom的ID
			data : data3,//绑定数据
			title : '线下辅导授课统计报表（图）',//设置标题
			width : 800,//设置宽度，默认单位为px
			height : 400,//设置高度，默认单位为px
			shadow : true,//激活阴影
			shadow_color : '#c7c7c7',//设置阴影颜色
			coordinate : {//配置自定义坐标轴
				scale : [ {//配置自定义值轴
					position : 'left',//配置左值轴	
					start_scale : 0,//设置开始刻度为0
					end_scale : 10,//设置结束刻度为26
					scale_space : 2,//设置刻度间距
					listeners : {//配置事件
						parseText : function(t, x, y) {//设置解析值轴文本
							return {
								text : t + " T"
							}
						}
					}
				} ]
			}
		});
		var chart4 = new iChart.Column2D({
			render : 'canvasDiv4',//渲染的Dom目标,canvasDiv为Dom的ID
			data : data4,//绑定数据
			title : '总统计报表（图）',//设置标题
			width : 800,//设置宽度，默认单位为px
			height : 400,//设置高度，默认单位为px
			shadow : true,//激活阴影
			shadow_color : '#c7c7c7',//设置阴影颜色
			coordinate : {//配置自定义坐标轴
				scale : [ {//配置自定义值轴
					position : 'left',//配置左值轴	
					start_scale : 0,//设置开始刻度为0
					end_scale : 10,//设置结束刻度为26
					scale_space : 2,//设置刻度间距
					listeners : {//配置事件
						parseText : function(t, x, y) {//设置解析值轴文本
							return {
								text : t + " T"
							}
						}
					}
				} ]
			}
		});
		//调用绘图方法开始绘图
		chart1.draw();
		chart2.draw();
		chart3.draw();
		chart4.draw();
	});
</script>