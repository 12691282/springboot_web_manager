<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/core/base.jsp"%>

<div class="modal-dialog"><!-- dialog start -->
	<div class="modal-content" > <!-- content start -->

			主键ID :<input class="form-control" style="height:30px;" name="userId"  value="${sysUser.userId}"  type="text" placeholder="请输入主键ID" maxlength="11"/>
		</div>
		<div class="control-group">
			用户名 :<input class="form-control" style="height:30px;" name="username"  value="${sysUser.username}"  type="text" placeholder="请输入用户名" maxlength="64"/>

			 :<input class="form-control" style="height:30px;" name="password"  value="${sysUser.password}"  type="text" placeholder="请输入" maxlength="64"/>
		</div>
		<div class="control-group">
			用户别名 :<input class="form-control" style="height:30px;" name="aliasName"  value="${sysUser.aliasName}"  type="text" placeholder="请输入用户别名" maxlength="20"/>

			创建时间 :<input class="form-control" style="height:30px;" name="createTime"  value="${sysUser.createTime}"  type="text" placeholder="请输入创建时间" maxlength=""/>
		</div>
		<div class="control-group">
			0-正常，1-删除 :<input class="form-control" style="height:30px;" name="statusFlag"  value="${sysUser.statusFlag}"  type="text" placeholder="请输入0-正常，1-删除" maxlength="1"/>

	</div><!-- /.modal-content end-->
</div><!-- /.modal end-->
