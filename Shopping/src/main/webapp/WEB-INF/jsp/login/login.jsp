<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/font.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/xadmin.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/cookie.js"></script>
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">乳酸菌平台系统</div>
        <div id="darkbannerwrap"></div>
        
        <form action="<%=request.getContextPath()%>/syslogin/dologin" method="post" class="layui-form" >
            <input name="email" id="email" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" id="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit" onlick="login(this)">
            <span>${error }</span> <span>${wrong }</span>
            <hr class="hr20" >
        </form>
    </div>
	<!-- <script type="text/javascript">
		function login(obj){
			var email = $(obj).parent().parent().find("td").eq(3).text();
			$.ajax({
				url:"dologin",
				data:{
					email:"email"
				},
				type:"get"
			})
		}
	</script> -->
</body>
</html>