<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>基本注册</title>
</head>
<body>
	<div >
		<form action="userservlet?xinxi=2" method="post">
		请输入您的姓名:<input type="text" name="uname"><br>
		请输入您的密码:<input type="text" name="upwd"><br>
		请再次输入您的密码:<input type="text" name="upwd2"><br>
		请输入您的身份证号码:<input type="text" name="uidcard"><br>
		请输入您的电话号码:<input type="text" name="phone"><br>
		请输入您的邮箱:<input type="text" name="email"><br>
		请输入您的家庭住址:<input type="text" name="add"><br>
		<input type="submit" value="提交">
		</form>
	</div>	
</body>
</html>