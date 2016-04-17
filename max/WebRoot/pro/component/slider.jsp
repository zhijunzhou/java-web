<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String pathSlider = request.getContextPath();
String basePathSlider = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathSlider+"/";
%>
<base href="<%=basePathSlider%>">

<div id="carousel-example-generic" class="carousel slide"
	data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#carousel-example-generic" data-slide-to="0"
			class="active"></li>
		<li data-target="#carousel-example-generic" data-slide-to="1"></li>
		<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		<li data-target="#carousel-example-generic" data-slide-to="3"></li>
	</ol>
	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img src="img/S1.png" alt="">
			<div class="carousel-caption">
				英语辅导！外教一对一辅导！
			</div>
		</div>
		<div class="item">
			<img src="img/S2.png" alt="...">
			<div class="carousel-caption">
				抽象艺术设计
			</div>
		</div>
		<div class="item">
			<img src="img/S3.png" alt="...">
			<div class="carousel-caption">
				最新大数据课程！
			</div>
		</div>
		<div class="item">
			<img src="img/S4.png" alt="">
			<div class="carousel-caption">
				你是否还会迷恋老师在黑板上用三角板画图...
			</div>
		</div>

	</div>

	<!-- Controls -->
	<a class="left carousel-control" href="#carousel-example-generic"
		role="button" data-slide="prev"> <span
		class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
		class="sr-only">Previous</span> </a>
	<a class="right carousel-control" href="#carousel-example-generic"
		role="button" data-slide="next"> <span
		class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span
		class="sr-only">Next</span> </a>

</div>


