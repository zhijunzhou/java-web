<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String pathChart = request.getContextPath();
String basePathChart = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathChart+"/";
%>
<base href="<%=basePathChart%>">
<div id="canvasDiv"></div>
<script type="text/javascript" src="js/drawChart.js"></script>
