<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<div class="col-md-12">
	<div class="lead pull-left"><b>${fn:length(students)} 位学生已注册该课程</b></div>
	<div class="pull-right">
		<a href="javascript::" title="短信通知所有人" style="margin-right: 10px;"><i class="glyphicon glyphicon-phone"></i></a>
		<a href="#" data-toggle="modal" data-target="#send-email-modal" title="发送邮件给所有人" style="margin-right: 10px;"><i class="glyphicon glyphicon-envelope"></i></a>
	</div>
</div>
<div class="col-md-12">
	<c:if test="${empty students }">
		未发现有学生注册该课程！
	</c:if>
	<c:forEach items="${students }" var="stu">
		<div class="col-lg-2 user-header text-center">
			<img src="img/avatar5.png" width="80" class="img-circle" alt="User Image">
			<p>
                  ${stu[0] }<br />
                  <small>${stu[1] }</small>
            </p>
		</div>
	</c:forEach>
</div>
<div class="modal fade" id="send-email-modal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><i class="glyphicon glyphicon-remove"></i></button>
		        <h4 class="modal-title">邮件通知</h4>
		      </div>
		      <div class="modal-body">
		      <h5>选择需要发送的用户：</h5>
		        <c:forEach items="${students }" var="stu">
		        	<input type="checkbox" class="mailaddr" value="${stu[1] }" /> <a>${stu[1] }</a><br />
		        </c:forEach>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" id="sendmail">发 送</button>
		      </div>
		</div>
	</div>
</div>
   