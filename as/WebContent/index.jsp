<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<script>var __links = document.querySelectorAll('a');function __linkClick(e) { parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>
<script src="js/jquery.min.js"></script>
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>


</head>
<body> 
	
	<div class="message warning">
<div class="inset">
	<div class="login-head">
		<h1>我不是企业人事管理系统</h1>
		 <div class="alert-close"> </div> 			
	</div>
		<form action="userservlet?xinxi=1" method="post">
			<li>
				<input  name="uid" type="text" class="text" value="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';} ">
			</li>
				<div class="clear"> </div>
			<li>
				<input  type="password" name="upwd"  ">
			</li>
			<div class="clear"> </div>
			<div class="submit">
				<input type="submit" onclick="myFunction()" value="Sign in" >
				<h4><a href="#">Lost your Password ?</a></h4>
						  <div class="clear">  </div>	
			</div>
				
		</form>
		</div>					
	</div>
	</div>
	<div class="clear"> </div>
<!--- footer --->
<div class="footer">
	<p>王涵 &copy; 2019.</p>
</div>

</body>
</html>