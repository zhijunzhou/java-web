<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String pathIndex = request.getContextPath();
String basePathIndex = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathIndex+"/";
%>
<base href="<%=basePathIndex%>">
<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
         Bai Max
        <small>Online Education System</small>
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">
      <!--<div class="callout callout-info">
        <h4>Tip!</h4>

        <p>Bai Max CMS will give you a suitable experience to manage your data.</p>
      </div>
      --><!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Teacher Control Panel</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="box-body">
          <%@include file="/teacher/teacherTable.jsp" %>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          
        </div>
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->