<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<form name="myform" action="teacher/addTeacher.do" method="post"
	enctype="multipart/form-data">
	<div class="row">
		<div class="col-lg-2 text-right">
			<span class="control-pane">机构名称</span>
		</div>
		<div class="col-lg-5">
			<input type="text" name="name" class="form-control" required />
		</div>
		<div class="col-lg-5">

		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			机构照片
		</div>
		<div class="col-lg-5">
			<div class="col-lg-10 input-group">
				<input type="file" name="avatar_url" class="form-control"
					placeholder="选择本地图片文件...">
				<span class="input-group-addon" id="basic-addon1"><i
					class="glyphicon glyphicon-folder-open"></i> 浏览...</span>
			</div>
		</div>
		<div class="col-lg-5">
			机构的logo 或门市招牌照片
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			注册日期
		</div>
		<div class="col-lg-5">
			<input type="text" name="" class="form-control" readonly />
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			联系电话
		</div>
		<div class="col-lg-5">
			<input type="text" name="celphone" class="form-control" required
				placeholder="如：02788108811" />
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			所在区域
		</div>
		<div class="col-lg-5">
			<input type="text" name="loc_id" required class="form-control"
				placeholder="如：湖北省武汉市" />
		</div>
		<div class="col-lg-5">
			机构当前所在的地理位置
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			所属分类
		</div>
		<div class="col-lg-5">
			<input type="text" name="org_name" required class="form-control"
				placeholder="如：华中科技大学" />
		</div>
		<div class="col-lg-5">
			如，中小学辅导、艺术、技术教育等等
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			单位属性
		</div>
		<div class="col-lg-5">
			<select class="form-control" name="org_type">
				<option value="1">
					公立学校
				</option>
				<option value="2">
					民办学校
				</option>
				<option value="3">
					培训机构
				</option>
				<option value="4">
					独立工作室
				</option>
			</select>
		</div>
		<div class="col-lg-5">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right">
			机构标签
		</div>
		<div class="col-lg-5">
			<input type="text" class="form-control" disabled="disabled" />
		</div>
		<div class="col-lg-5">
			平台赋予的一些机构标签
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2 text-right"></div>
		<div class="col-lg-2">
			<button type="reset" class="btn btn-default">
				撤 销
			</button>
		</div>
		<div class="col-lg-3">
			<button type="submit" class="btn btn-primary">
				保 存
			</button>
		</div>
		<div class="col-lg-5">
		</div>
	</div>
</form>