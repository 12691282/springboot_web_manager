<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/core/base.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>sysUser页面</title>
	<link rel="stylesheet" href="/js/plus/bootstrap/css/bootstrap.min.css"  media="screen">
	<link rel="stylesheet" href="/js/plus/bootstrap/css/bootstrap-responsive.min.css" >
	<!-- js 加载 -->
	<script type="text/javascript" src="/js/plus/jquery/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="/js/plus/jquery/jquery.form.min.js"></script>
	<script type="text/javascript" src="/js/plus/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/plus/bootstrap/js/tip.js"></script>
	<script type="text/javascript" src="/js/plus/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<!-- container start -->
	<div class="container">
		<legend> </legend>
		<form class="form-inline" role="form" action="list" method="post">
			主键ID :<input class="form-control" style="height:30px;" name="userId" value="${query.userId}" type="text"  placeholder="请输入主键ID" maxlength="11"/>
			<br/><br/>
			用户名 :<input class="form-control" style="height:30px;" name="username" value="${query.username}" type="text"  placeholder="请输入用户名" maxlength="64"/>
			 :<input class="form-control" style="height:30px;" name="password" value="${query.password}" type="text"  placeholder="请输入" maxlength="64"/>
			用户别名 :<input class="form-control" style="height:30px;" name="aliasName" value="${query.aliasName}" type="text"  placeholder="请输入用户别名" maxlength="20"/>
			<br/><br/>
			创建时间 :<input class="form-control" style="height:30px;" name="createTime" value="${query.createTime}" type="text"  placeholder="请输入创建时间" maxlength=""/>
			0-正常，1-删除 :<input class="form-control" style="height:30px;" name="statusFlag" value="${query.statusFlag}" type="text"  placeholder="请输入0-正常，1-删除" maxlength="1"/>
			<button class="btn btn-success query">查询</button>
			<button class="btn btn-primary reset">重置</button>
		</form>
		<legend></legend>
		<div>
			<button class="btn btn-inverse" id="addModel">新增</button>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th></th>
					<th>主键ID</th>
					<th>用户名</th>
					<th></th>
					<th>用户别名</th>
					<th>创建时间</th>
					<th>0-正常，1-删除</th>
					<th>操作</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${data.list}" var="v" varStatus="status">
					<tr>
						<td><input type="checkbox" value="${v}"></td>
						<td>${v.userId}</td>
						<td>${v.username}</td>
						<td>${v.password}</td>
						<td>${v.aliasName}</td>
						<td>${v.createTime}</td>
						<td>${v.statusFlag}</td>
						<td>
							<button class="btn btn-success" type="button" value="${v.id}">修改</button>&nbsp;
							<button class="btn btn-danger" type="button" value="${v.id}">删除</button>
						</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<%@ include file="/WEB-INF/core/page.jsp"%>
		<div class="footer">
			<p>&copy; lion 2017</p>
		</div>

	</div>



<!-- model start -->
	<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" style="width: 700px;" aria-hidden="true">
	<form action="addOrModify" method="post">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">信息</h4>
				</div>
				<div class="modal-body form-horizontal">
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal " id="addOrUpdateModel" >确定</button>
			</div>
		</div>
	</form>
	</div>
<!-- model end -->
</body>

<script type="text/javascript">
	$(document).ready(function() {
		function showModel(_id) {
			var url = "getBeanById";
			if (_id) {
				url += ("?id=" + _id);
			}
			$("#infoModal").modal({
				remote : url
			});
		}
		
		//新增模块显示
		$("#addModel").on("click", function() {
			showModel();
			return false;
		});
		
		
		$("#infoModal").on("hidden", function() {
			$(this).removeData("modal");
		});

		$(".query").on("click", function() {
			$("form[action='list']").submit();
			return false;
		});
		
		$(".reset").on("click", function() {
			$("form[action='list']").find("input").val('');
			return false;
		});

		$("#addOrUpdateModel").click(function() {
			
			$("form[action='addOrModify']").ajaxSubmit({
	            success: function(_result) { // data 保存提交后返回的数据，一般为 json 数据
	            	$("#infoModal").hide();
	            	if(_result && _result.info == "1"){
	            		Modal.showConfirm(_result.data, function(){

	            			window.location.href = "list";
	            		});
	            	}
	            }	
	        });
		  
			return false;
		})

		$("table tbody tr").find(".btn-success").on('click', function() {
			showModel($(this).val());
			return false;
		})

		$("table tbody tr").find(".btn-danger").on('click', function() {
			var idVal = $(this).val();

			Modal.showConfirm('确定删除该记录？', function() {

				$.post("delete", {
					id : idVal
				}, function(msg) {
					Modal.showMsg(msg.data, function() {
						if (msg && msg.info == 1) {
							$(window).attr('location', "list");
						}
					});
				});

			});
			return false;
		})

	});
</script>
</html>

