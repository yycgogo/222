<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>欢迎页面-X-admin2.1</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<link rel="stylesheet" href="./css/layui.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<script type="text/javascript" src="./js/cookie.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="x-nav">
	 <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form action="<%=request.getContextPath()%>/user_del_sel"
				class="layui-form layui-col-md12 x-so">
				<input type="text" name="username" placeholder="请输入用户名"
					autocomplete="off" class="layui-input">
				<button type="submit" class="layui-btn" lay-submit=""
					lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<span class="x-right" style="line-height: 40px">共有数据：${page.total}
			条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>ID</th>
					<th>用户名</th>
					<th>手机</th>
					<th>邮箱</th>
					<th>生日</th>
					<th>头像</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.list }" var="user">
					<tr>
						<td>${user.u_id }</td>
						<td>${user.u_name }</td>
						<td>${user.u_telephone }</td>
						<td>${user.u_email }</td>
						<td>${user.u_birthday }</td>
						<td>${user.u_photo }</td>
						<td class="td-manage"><a title="删除"
							onclick="member_del(this)"> <i
								class="layui-icon">&#xe640;</i>
						</a><a title="封号"
							onclick="member_change(this)"> <i
								class="layui-icon">&#xe642;</i>
						</a></td>
					</tr>
				</c:forEach>
		</table>
	</div>

	<div id="test1"></div>

	<script src="./lib/layui/layui.js"></script>
	<script>
		layui.use('laypage', function() {
			var laypage = layui.laypage;

			//执行一个laypage实例
			laypage.render({
				elem : 'test1', //注意，这里的 test1 是 ID，不用加 # 号
				count : ${page.total}
			//数据总数，从服务端得到
			});
		});
	</script>
	<script>
		/*用户-删除*/
		function member_del(obj) {
			var c = confirm("确定删除这个用户吗？");
			var u_id = $(obj).parent().parent().find("td").eq(0).text();
			console.log(u_id);
			if(c){
				$.ajax({
					url:"user_del",
					type:"get",
					data:{
						"u_id":u_id
					},
					success:function(data){
						window.location.reload();
						alert("删除成功");
					},
					error:function(){
						alert("请求失败");
					}
				})
			}
		}
	</script>
	<script>
		/*用户-封禁*/
		function member_change(obj) {
			var c = confirm("确定封禁这个用户吗？");
			var u_id = $(obj).parent().parent().find("td").eq(0).text();
			if(c){
				$.ajax({
					url:"user_change",
					type:"get",
					data:{
						"u_id":u_id
					},
					success:function(data){
						window.location.reload();
						alert("删除成功");
					},
					error:function(){
						alert("请求失败");
					}
				})
			}
		}
	</script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>

</body>

</html>