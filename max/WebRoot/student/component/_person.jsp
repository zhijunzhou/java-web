<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String pathPerson = request.getContextPath();
String basePathPerson = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathPerson+"/";
%>
<base href="<%=basePathPerson%>">
  