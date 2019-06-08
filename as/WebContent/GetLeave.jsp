<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>提交请教表</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

function getLeave() {
    $.ajax({
    //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "userservlet?xinxi=getleave" ,//url
        data: {"uid":161164272},
        success: function (result) {
            alert(result+"11111111111111111")
            
            ;
        },
       
    });
}

</script>
</head>
<body>
<form >
<button onclick="getLeave()">aa</button>
layui
easyui
</form>
<button onclick="getLeave()">aa</button>
</body>
</html>