<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

 <link rel="stylesheet" href="layui/css/layui.css"  media="all">
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link type="text/css" rel="stylesheet" href="css/css.css" />

<script src="layui/layui.js" charset="utf-8"></script>

<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,url:'/demo/'
    ,cols: [[
      {field:'id', width:80, title: 'ID', sort: true}
      ,{field:'username', width:80, title: '用户名'}
      ,{field:'sex', width:80, title: '性别', sort: true}
      ,{field:'city', width:80, title: '城市'}
      ,{field:'sign', title: '签名', minWidth: 150}
      ,{field:'experience', width:80, title: '积分', sort: true}
      ,{field:'score', width:80, title: '评分', sort: true}
      ,{field:'classify', width:80, title: '职业'}
      ,{field:'wealth', width:135, title: '财富', sort: true}
    ]]
    ,page: true
  });
});
</script>

<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //常规用法
  laydate.render({
    elem: '#test1'
  });

 
});
</script>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
var uid="<%=session.getAttribute("uid")%>"

function YYYYMMDDstart()   
{   
        MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];   
 
        //先给年下拉框赋内容   
        var y  = new Date().getFullYear();   
        for (var i = (y-10); i < (y+11); i++) 
                document.reg_testdate.YYYY.options.add(new Option(" "+ i +" 年", i));   
 
        //赋月份的下拉框   
        for (var i = 1; i < 13; i++)   
                document.reg_testdate.MM.options.add(new Option(" " + i + " 月", i));   
 
        document.reg_testdate.YYYY.value = y;   
        document.reg_testdate.MM.value = new Date().getMonth() + 1;   
        var n = MonHead[new Date().getMonth()];   
        if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;   
             writeDay(n); //赋日期下拉框Author:meizz   
        document.reg_testdate.DD.value = new Date().getDate();   
}   
if(document.attachEvent)   
    window.attachEvent("onload", YYYYMMDDstart);   
else   
    window.addEventListener('load', YYYYMMDDstart, false);   
function YYYYDD(str) //年发生变化时日期发生变化(主要是判断闰平年)   
{   
        var MMvalue = document.reg_testdate.MM.options[document.reg_testdate.MM.selectedIndex].value;   
        if (MMvalue == ""){ var e = document.reg_testdate.DD; optionsClear(e); return;}   
        var n = MonHead[MMvalue - 1];   
        if (MMvalue ==2 && IsPinYear(str)) n++;   
             writeDay(n)   
}   
function MMDD(str)   //月发生变化时日期联动   
{   
     var YYYYvalue = document.reg_testdate.YYYY.options[document.reg_testdate.YYYY.selectedIndex].value;   
     if (YYYYvalue == ""){ var e = document.reg_testdate.DD; optionsClear(e); return;}   
     var n = MonHead[str - 1];   
     if (str ==2 && IsPinYear(YYYYvalue)) n++;   
    writeDay(n)   
}   
function writeDay(n)   //据条件写日期的下拉框   
{   
        var e = document.reg_testdate.DD; optionsClear(e);   
        for (var i=1; i<(n+1); i++)   
             e.options.add(new Option(" "+ i + " 日", i));   
}   
function IsPinYear(year)//判断是否闰平年   
{     return(0 == year%4 && (year%100 !=0 || year%400 == 0));}   
function optionsClear(e)   
{   
     e.options.length = 1;   
} 


function YYYYYMMMDDDstart()   
{   
        MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];   
 
        //先给年下拉框赋内容   
        var y  = new Date().getFullYear();   
        for (var i = (y-10); i < (y+11); i++) 
                document.reg_testdate.YYYYY.options.add(new Option(" "+ i +" 年", i));   
 
        //赋月份的下拉框   
        for (var i = 1; i < 13; i++)   
                document.reg_testdate.MMM.options.add(new Option(" " + i + " 月", i));   
 
        document.reg_testdate.YYYYY.value = y;   
        document.reg_testdate.MMM.value = new Date().getMonth() + 1;   
        var n = MonHead[new Date().getMonth()];   
        if (new Date().getMonth() ==1 && IsPinYear(YYYYYvalue)) n++;   
             writeDay2(n); //赋日期下拉框Author:meizz   
        document.reg_testdate.DDD.value = new Date().getDate();   
}   
if(document.attachEvent)   
    window.attachEvent("onload", YYYYYMMMDDDstart);   
else   
    window.addEventListener('load', YYYYYMMMDDDstart, false);   
function YYYYYDDD(str2) //年发生变化时日期发生变化(主要是判断闰平年)   
{   
        var MMMvalue = document.reg_testdate.MMM.options[document.reg_testdate.MMM.selectedIndex].value;   
        if (MMMvalue == ""){ var e = document.reg_testdate.DDD; optionsClear(e); return;}   
        var n = MonHead[MMMvalue - 1];   
        if (MMMvalue ==2 && IsPinYear(str2)) n++;   
             writeDay2(n)   
}   
function MMMDDD(str2)   //月发生变化时日期联动   
{   
     var YYYYYvalue = document.reg_testdate.YYYYY.options[document.reg_testdate.YYYYY.selectedIndex].value;   
     if (YYYYYvalue == ""){ var e = document.reg_testdate.DDD; optionsClear(e); return;}   
     var n = MonHead[str - 1];   
     if (str2 ==2 && IsPinYear(YYYYYvalue)) n++;   
    writeDay2(n)   
}   
function writeDay2(n)   //据条件写日期的下拉框   
{   
        var e = document.reg_testdate.DDD; optionsClear(e);   
        for (var i=1; i<(n+1); i++)   
             e.options.add(new Option(" "+ i + " 日", i));   
}   
function IsPinYear(year)//判断是否闰平年   
{     return(0 == year%4 && (year%100 !=0 || year%400 == 0));}   
function optionsClear(e)   
{   
     e.options.length = 1;   
} 

function sign(){ //用户签到记录
	var uid="<%=session.getAttribute("uid")%>"
    $.ajax({
        type: "POST",                            //传数据的方式
        url: "userservlet?xinxi=sign",                             //servlet地址
       	date:{"uid":uid},
        success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            alert(result);           //找到输入框 并且将result的值 传进去
        }
    });
}
function afterwork(){ //用户签退打卡
	var uid="<%=session.getAttribute("uid")%>"
    $.ajax({
        type: "POST",                            //传数据的方式
        url: "userservlet?xinxi=aw",                             //servlet地址
        date:{"uid":uid},
        success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            alert(result);           //找到输入框 并且将result的值 传进去
        }
    });
}
function nsign(){ //用户签退打卡
	var uid="<%=session.getAttribute("uid")%>"
    $.ajax({
        type: "POST",                            //传数据的方式
        url: "userservlet?xinxi=nsign",                             //servlet地址
        data:{"uid":uid},
        success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            alert(result);           //找到输入框 并且将result的值 传进去
        }
    });
}
function naw(){ //用户签退打卡
	var uid="<%=session.getAttribute("uid")%>"
    $.ajax({
        type: "POST",                            //传数据的方式
        url: "userservlet?xinxi=naw",                             //servlet地址
        data:{"uid":uid},
        success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
            alert(result);           //找到输入框 并且将result的值 传进去
        }
    });
}
$(document).ready(function(){   //用户基本信息隐藏于显示
	$("#queryusertable").hide();
	$("#userdiv").hide();
	$("#wplandiv").hide();
	$("#attdiv").hide();
	$("#staffdiv").hide();
	$("#tsleavediv").hide();
	$("#tstripdiv").hide();
	$("#queryuserdiv").hide();
	$("#tripdiv").hide();
	$("#leavediv").hide();
	$("#queryleavediv").hide();
	$("#querytripdiv").hide();
	
	$("#user").click(function(){
		$("#userdiv").toggle();
		$("#attdiv").hide();
		$("#wplandiv").hide();
		$("#staffdiv").hide();
		$("#tsleavediv").hide();
		$("#tstripdiv").hide();
		$("#queryuserdiv").hide();
		$("#tripdiv").hide();
		$("#leavediv").hide();
		$("#queryleavediv").hide();
		$("#querytripdiv").hide();
	})
	$("#att").click(function(){
		$("#attdiv").toggle();
		$("#userdiv").hide();
		$("#wplandiv").hide();
		$("#staffdiv").hide();
		$("#tsleavediv").hide();
		$("#tstripdiv").hide();
		$("#queryuserdiv").hide();
		$("#tripdiv").hide();
		$("#leavediv").hide();
		$("#queryleavediv").hide();
		$("#querytripdiv").hide();
	})
	$("#wageplan").click(function(){
		$("#attdiv").hide();
		$("#userdiv").hide();
		$("#wplandiv").toggle();
		$("#staffdiv").hide();
		$("#tsleavediv").hide();
		$("#tstripdiv").hide();
		$("#queryuserdiv").hide();
		$("#tripdiv").hide();
		$("#leavediv").hide();
		$("#queryleavediv").hide();
		$("#querytripdiv").hide();
	})
	$("#staff").click(function(){
		$("#attdiv").hide();
		$("#userdiv").hide();
		$("#wplandiv").hide();
		$("#staffdiv").toggle();
		$("#tsleavediv").hide();
		$("#tstripdiv").hide();
		$("#queryuserdiv").hide();
		$("#tripdiv").hide();
		$("#leavediv").hide();
		$("#queryleavediv").hide();
		$("#querytripdiv").hide();
	})
	$("#tsleave").click(function(){
		$("#attdiv").hide();
		$("#userdiv").hide();
		$("#wplandiv").hide();
		$("#staffdiv").hide();
		$("#tsleavediv").toggle();
		$("#tstripdiv").hide();
		$("#queryuserdiv").hide();
		$("#tripdiv").hide();
		$("#leavediv").hide();
		$("#queryleavediv").hide();
		$("#querytripdiv").hide();
	})
	$("#tstrip").click(function(){
		$("#attdiv").hide();
		$("#userdiv").hide();
		$("#wplandiv").hide();
		$("#staffdiv").hide();
		$("#tsleavediv").hide();
		$("#tstripdiv").toggle();
		$("#queryuserdiv").hide();
		$("#tripdiv").hide();
		$("#leavediv").hide();
		$("#queryleavediv").hide();
		$("#querytripdiv").hide();
	})
	$("#queryuser").click(function(){
		$("#attdiv").hide();
		$("#userdiv").hide();
		$("#wplandiv").hide();
		$("#staffdiv").hide();
		$("#tsleavediv").hide();
		$("#tstripdiv").hide();
		$("#queryuserdiv").toggle();
		$("#tripdiv").hide();
		$("#leavediv").hide();
		$("#queryleavediv").hide();
		$("#querytripdiv").hide();
		
		var qdname = $("*[name='qdname']").val();
		if(qdname=="不限制"){
			$("#qpname").append("<option value='不限制'>不限制</option>");
		}
		
		$(document).on("change",'select#qdname',function(){
			var qdname = $("*[name='qdname']").val();
			if(qdname=="不限制"){
				$("#qpname").empty();
				$("#qpname").append("<option value='不限制'>不限制</option>");
			}else{
			var qdname = $("*[name='qdname']").val();
			$("#qpname").empty();
			$("#qpname").append("<option value='不限制'>不限制</option>");

			$("#qpname").append("<option value='"+qdname+"部长"+"'>"+qdname+"部长"+"</option>");
			$("#qpname").append("<option value='"+qdname+"主管"+"'>"+qdname+"主管"+"</option>");
			$("#qpname").append("<option value='"+qdname+"组长"+"'>"+qdname+"组长"+"</option>");
			$("#qpname").append("<option value='"+qdname+"资深员工"+"'>"+qdname+"资深员工"+"</option>");
			$("#qpname").append("<option value='"+qdname+"员工"+"'>"+qdname+"员工"+"</option>");
			$("#qpname").append("<option value='"+qdname+"临时员工"+"'>"+qdname+"临时员工"+"</option>");
			}
		});
		
		$("#subquser").click(function(){
			$("#queryusertable").show();
			
			//AJAX写入，接收后台数据遍历到queryusertable表格中
			
		})
	})
	$("#trip").click(function(){
		$("#attdiv").hide();
		$("#userdiv").hide();
		$("#wplandiv").hide();
		$("#staffdiv").hide();
		$("#tsleavediv").hide();
		$("#tstripdiv").hide();
		$("#queryuserdiv").hide();
		$("#tripdiv").toggle();
		$("#leavediv").hide();
		$("#queryleavediv").hide();
		$("#querytripdiv").hide();
	})
	$("#leave").click(function(){
		$("#attdiv").hide();
		$("#userdiv").hide();
		$("#wplandiv").hide();
		$("#staffdiv").hide();
		$("#tsleavediv").hide();
		$("#tstripdiv").hide();
		$("#queryuserdiv").hide();
		$("#tripdiv").hide();
		$("#leavediv").toggle();
		$("#queryleavediv").hide();
		$("#querytripdiv").hide();
	})
	$("#queryleave").click(function(){
		$("#attdiv").hide();
		$("#userdiv").hide();
		$("#wplandiv").hide();
		$("#staffdiv").hide();
		$("#tsleavediv").hide();
		$("#tstripdiv").hide();
		$("#queryuserdiv").hide();
		$("#tripdiv").hide();
		$("#leavediv").hide();
		$("#queryleavediv").toggle();
		$("#querytripdiv").hide();
	})
	$("#querytrip").click(function(){
		$("#attdiv").hide();
		$("#userdiv").hide();
		$("#wplandiv").hide();
		$("#staffdiv").hide();
		$("#tsleavediv").hide();
		$("#tstripdiv").hide();
		$("#queryuserdiv").hide();
		$("#tripdiv").hide();
		$("#leavediv").hide();
		$("#queryleavediv").hide();
		$("#querytripdiv").toggle();
	})
	
	
	//页面加载后台数据
	
	
	
})

function queryUser(){  //检索用户个人信息
	var uid="<%=session.getAttribute("uid")%>"
		$.ajax({
			 type: "POST",                            //传数据的方式
		     url: "userservlet?xinxi=queryUser",                             //servlet地址
		     data:{"uid":uid},//提交到后台的数据
		 //    dateType:"json";//回调函数接收数据的数据格式
		     success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
		    	var t = $.parseJSON(result); //声明变量t 接收后台传递的JSON对象
		     	$("#uid").html(t.uid);
		     	$("#uname").html(t.uname);
		     	$("#ugen").html(t.ugen);
		     	$("#unational").html(t.unational);
		     	$("#uborndate").html(t.uborndate);
		     	$("#unplace").html(t.unplace);
		     	$("#uidcard").html(t.uidcard);
		     	$("#pid").html(t.pid);
		     	$("#sdate").html(t.sdate);
		     	$("#did").html(t.did);
		     	$("#title").html(t.title);
		     	$("#startdate").html(t.startdate);
		     	$("#unito").html(t.unito);
		     	$("#unitt").html(t.unitt);
		     	$("#unitp").html(t.unitp);
		     	$("#gschool").html(t.gschool);
		     	$("#gdate").html(t.gdate);
		     	$("#pro").html(t.pro);
		     	$("#edu").html(t.edu);
		     	$("#lan").html(t.lan);
		     	$("#add").html(t.add);
		     	$("#phone").html(t.phone);
		     	$("#email").html(t.email);
		     	
		     } 
		})
	}
function queryAtt(){ //用户签退打卡
	var uid="<%=session.getAttribute("uid")%>"
    $.ajax({
        type: "POST",                            //传数据的方式
        url: "userservlet?xinxi=queryAtt",                             //servlet地址
        data:{"uid":uid},
        success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
           
        	var list = $.parseJSON(result);
        	
        $.each(list,function(indax,item){	
        		var tr = document.createElement("tr");//创建tr
        		var td1 = document.createElement("td");//创建td
        		td1.innerHTML=list[indax].aid;
        		var td2 = document.createElement("td");//创建td
        		td2.innerHTML=list[indax].uid;
        		var td3 = document.createElement("td");//创建td
        		td3.innerHTML=list[indax].adate;
        		var td4 = document.createElement("td");//创建td
        		td4.innerHTML=list[indax].atype;
        		var td5 = document.createElement("td");//创建td
        		td5.innerHTML=list[indax].signday;
        		var td6 = document.createElement("td");//创建td
        		td6.innerHTML=list[indax].workday;
        		var td7 = document.createElement("td");//创建td
        		td7.innerHTML=list[indax].absday;
        		var td8 = document.createElement("td");//创建td
        		td8.innerHTML=list[indax].lateday;
        		var td9 = document.createElement("td");//创建td
        		td9.innerHTML=list[indax].leaveday;
        		var td10 = document.createElement("td");//创建td
        		td10.innerHTML=list[indax].atext;
        		var td11= document.createElement("td");//创建td
        		td11.innerHTML=list[indax].uname;
        		tr.appendChild(td1);
        		tr.appendChild(td2);
        		tr.appendChild(td3);
        		tr.appendChild(td4);
        		tr.appendChild(td5);
        		tr.appendChild(td6);
        		tr.appendChild(td7);
        		tr.appendChild(td8);
        		tr.appendChild(td9);
        		tr.appendChild(td10);
        		tr.appendChild(td11);
        		var listbody = document.getElementById("atttable");
        		listbody.appendChild(tr);
        		
        		
        		$("#att").removeAttr("onclick");//防止二次点击后重复查询遍历
        		
        	});
        }
    });
    
}
function queryWPlan(){ //用户签退打卡
	var uid="<%=session.getAttribute("uid")%>"
    $.ajax({
        type: "POST",                            //传数据的方式
        url: "userservlet?xinxi=queryWPlan",                             //servlet地址
        data:{"uid":uid},
        success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
           	var list = $.parseJSON(result);
        	

           	$.each(list,function(indax,item){	
           		var tr = document.createElement("tr");//创建tr
           		var td1 = document.createElement("td");//创建td
           		td1.innerHTML=list[indax].wpid;
           		var td2 = document.createElement("td");//创建td
           		td2.innerHTML=list[indax].uid;
           		var td3 = document.createElement("td");//创建td
           		td3.innerHTML=list[indax].wid;
           		var td4 = document.createElement("td");//创建td
           		td4.innerHTML=list[indax].base;
           		var td5 = document.createElement("td");//创建td
           		td5.innerHTML=list[indax].sub;
           		var td6 = document.createElement("td");//创建td
           		td6.innerHTML=list[indax].bonus;
           		var td7 = document.createElement("td");//创建td
           		td7.innerHTML=list[indax].car;
           		var td8 = document.createElement("td");//创建td
           		td8.innerHTML=list[indax].house;
           		var td9 = document.createElement("td");//创建td
           		td9.innerHTML=list[indax].assbluckle;
           		var td10 = document.createElement("td");//创建td
           		td10.innerHTML=list[indax].work;
           		var td11= document.createElement("td");//创建td
           		td11.innerHTML=list[indax].pbluckle;
           		var td12= document.createElement("td");//创建td
           		td12.innerHTML=list[indax].mbluckle;
           		var td13= document.createElement("td");//创建td
           		td13.innerHTML=list[indax].hbluckle;
           		var td14= document.createElement("td");//创建td
           		td14.innerHTML=list[indax].all;
           		var td15= document.createElement("td");//创建td
           		td15.innerHTML=list[indax].income;
           		var td16= document.createElement("td");//创建td
           		td16.innerHTML=list[indax].wage;
           		var td17= document.createElement("td");//创建td
           		td17.innerHTML=list[indax].wdate;
           		tr.appendChild(td1);
           		tr.appendChild(td2);
           		tr.appendChild(td3);
           		tr.appendChild(td4);
           		tr.appendChild(td5);
           		tr.appendChild(td6);
           		tr.appendChild(td7);
           		tr.appendChild(td8);
           		tr.appendChild(td9);
           		tr.appendChild(td10);
           		tr.appendChild(td11);
           		tr.appendChild(td12);
           		tr.appendChild(td13);
           		tr.appendChild(td14);
           		tr.appendChild(td15);
           		tr.appendChild(td16);
           		tr.appendChild(td17);
           		var listbody = document.getElementById("wplantable");
           		listbody.appendChild(tr);
           		
           		$("#wageplan").removeAttr("onclick");//防止二次点击后重复查询遍历
           	});
        }
    });
    
}
function queryStaff(){ //用aff户录用信息表
    $.ajax({
        type: "POST",                            //传数据的方式
        url: "userservlet?xinxi=queryStaff",                             //servlet地址
        data:{"uid":uid},
        success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
           
        	var list = $.parseJSON(result);

        		var tr = document.createElement("tr");//创建tr
        		var td1 = document.createElement("td");//创建td
        		td1.innerHTML=list.sid;
        		var td2 = document.createElement("td");//创建td
        		td2.innerHTML=list.uid;
        		var td3 = document.createElement("td");//创建td
        		td3.innerHTML=list.uname;
        		var td4 = document.createElement("td");//创建td
        		td4.innerHTML=list.sdate;
        		var td5 = document.createElement("td");//创建td
        		td5.innerHTML=list.sedate;
        		var td6 = document.createElement("td");//创建td
        		td6.innerHTML=list.stype;
        		var td7 = document.createElement("td");//创建td
        		td7.innerHTML=list.ed;
        		var td8 = document.createElement("td");//创建td
        		td8.innerHTML=list.ep;
        		var td9 = document.createElement("td");//创建td
        		td9.innerHTML=list.em;
        		var td10 = document.createElement("td");//创建td
        		td10.innerHTML=list.stext;
        		
        		tr.appendChild(td1);
        		tr.appendChild(td2);
        		tr.appendChild(td3);
        		tr.appendChild(td4);
        		tr.appendChild(td5);
        		tr.appendChild(td6);
        		tr.appendChild(td7);
        		tr.appendChild(td8);
        		tr.appendChild(td9);
        		tr.appendChild(td10);
        		var listbody = document.getElementById("stafftable");
        		listbody.appendChild(tr);
        		$("#staff").removeAttr("onclick");//防止二次点击后重复查询遍历
        		
        		
        }
    });
    
}
function getTsLeave() {
    $.ajax({
    //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "userservlet?xinxi=getleave",//url
        data: $('#tsleaveform').serialize(),
        success: function (result) {
        	
           if(result=="1"){
        	   alert("请假单已提交，请耐心等待!");
           }else{
        	   alert("您已提交过，请耐心等待");
           }
              
        }
       	
    });
}
function getTsTrip() {
    $.ajax({
    //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "userservlet?xinxi=gettrip",//url
        data: $('#tstripform').serialize(),
        success: function (result) {
        	
           if(result=="1"){
        	   alert("请假单已提交，请耐心等待!");
           }else{
        	   alert("您已提交过，请耐心等待");
           }
              
        }
       	
    });
}

function queryUserDP(){ //员工信息表查询
	var quid=$("#quid").val();
	var quname=$("#quname").val();
	var qdname=$("#qdname").val();
	var qpname=$("#qpname").val();
	var qtrip=$("#qtrip").val();
	var qleave=$("#qleave").val();
	
    $.ajax({
        type: "POST",                            //传数据的方式
        url: "userservlet?xinxi=queryUserDP",                             //servlet地址
        data:{"quid":quid,"quname":quname,"qdname":qdname,"qpname":qpname,"qtrip":qtrip,"qleave":qleave},
        success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
        	var list = $.parseJSON(result);
        	$("#queryusertable").html($("#queryusertablefirsttr"));
        	$.each(list,function(indax,item){	
        		var tr = document.createElement("tr");//创建tr
           		var td1 = document.createElement("td");//创建td
           		td1.innerHTML=list[indax].uid;
           		var td2 = document.createElement("td");//创建td
           		td2.innerHTML=list[indax].uname;
           		var td3 = document.createElement("td");//创建td
           		td3.innerHTML=list[indax].utype;
           		var td4 = document.createElement("td");//创建td
           		td4.innerHTML=list[indax].add;
           		var td5 = document.createElement("td");//创建td
           		td5.innerHTML=list[indax].phone;
           		var td6 = document.createElement("td");//创建td
           		td6.innerHTML=list[indax].email;
           		var td7 = document.createElement("td");//创建td
           		td7.innerHTML=list[indax].depuser.dname;
           		var td8 = document.createElement("td");//创建td
           		td8.innerHTML=list[indax].depuser.pname;
           		
           		tr.appendChild(td1);
           		tr.appendChild(td2);
           		tr.appendChild(td3);
           		tr.appendChild(td4);
           		tr.appendChild(td5);
           		tr.appendChild(td6);
           		tr.appendChild(td7);
           		tr.appendChild(td8);
           		
           		var listbody = document.getElementById("queryusertable");
           		listbody.appendChild(tr);
           		
           		
           	});
        		
        		
        }
    });
    
}

function getTrip() {
    $.ajax({
    //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "userservlet?xinxi=trip",//url
        data: {"uid":uid},
        success: function (result) {
        	
        	//var list = $.parseJSON(result);
        	var list = result;
        	$("#triptable1").html($("#triptable1firsttr"));
        	
        	$.each(list,function(indax,item){	
        		var bt =document.createElement("button"); 
        		 
        		var tr = document.createElement("tr");//创建tr
        		var td1 = document.createElement("td");//创建td
           		td1.innerHTML="<p name='triptableuid' value='"+list[indax].uid+"' id='triptableuid"+indax+"'>"+list[indax].uid+"</p>";
           		var td2 = document.createElement("td");//创建td
           		td2.innerHTML=list[indax].uname;
           		var td3 = document.createElement("td");//创建td
           		td3.innerHTML=list[indax].dep;
           		var td4 = document.createElement("td");//创建td
           		td4.innerHTML=list[indax].pos;
           		var td5 = document.createElement("td");//创建td
           		td5.innerHTML=list[indax].tnum;
           		var td6 = document.createElement("td");//创建td
           		td6.innerHTML=list[indax].tplace;
           		var td7 = document.createElement("td");//创建td
           		td7.innerHTML=list[indax].tstart;
           		var td8 = document.createElement("td");//创建td
           		td8.innerHTML=list[indax].tend;
           		var td9 = document.createElement("td");//创建td
           		td9.innerHTML=list[indax].tend;
           		var td10 = document.createElement("td");//创建td
           		td10.innerHTML=list[indax].treason;
           		var td11 = document.createElement("td");//创建td
           		td11.innerHTML="<input id='triptable1addbut"+indax+"' type='button'  value='通过'  onclick='getUserTrip("+indax+")'></input><input id='triptable1delbut"+indax+"' type='button'  value='删除'  onclick='delUserTrip("+indax+")'></input>";
           		
           		
           		
           		
           		tr.appendChild(td1);
           		tr.appendChild(td2);
           		tr.appendChild(td3);
           		tr.appendChild(td4);
           		tr.appendChild(td5);
           		tr.appendChild(td6);
           		tr.appendChild(td7);
           		tr.appendChild(td8);
           		tr.appendChild(td9);
           		tr.appendChild(td10);
           		tr.appendChild(td11);
           		var listbody = document.getElementById("triptable1");
           		listbody.append(tr);
           		
           		
           		
           		
           	});
        		
              
        }
        
       	
    });
	
}
function getUserTrip(indax){
	//获取用户的个人请假审批表进行审批,通过并添加到出差表中	
	var triptableuid=$("#triptableuid"+indax).html();
	var r = confirm("确定要通过批准吗?!!");
	if(r==true){
	  $.ajax({
		    //几个参数需要注意一下
		        type: "POST",//方法类型
		        dataType: "json",//预期服务器返回的数据类型
		        url: "userservlet?xinxi=trippass",//url
		        data: {"uid":uid,"triptableuid":triptableuid},
		        success: function (result) {
		        	getTrip();
		        		
		              
		        }
		        
		       	
		    });
	}
}
function delUserTrip(indax){
	//获取用户的个人请假审批表进行审批,不通过,删除审批表信息
	var triptableuid=$("#triptableuid"+indax).html();
	var r = confirm("确定要删除吗?!!");
	if(r==true){
	  $.ajax({
		    //几个参数需要注意一下
		        type: "POST",//方法类型
		        dataType: "json",//预期服务器返回的数据类型
		        url: "userservlet?xinxi=notrippass",//url
		        data: {"triptableuid":triptableuid},
		        success: function (result) {
		        	getTrip();
		        		
		              
		        }
		        
		       	
		    });
	}
	
}

//用户请假处理
function getLeave() {
    $.ajax({
    //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "userservlet?xinxi=leave",//url
        data: {"uid":uid},
        success: function (result) {
        	
        	//var list = $.parseJSON(result);
        	var list = result;
        	$("#leavetable").html($("#leavetablefirsttr"));
        	
        	$.each(list,function(indax,item){	
        		var bt =document.createElement("button"); 
        		 
        		var tr = document.createElement("tr");//创建tr
        		var td1 = document.createElement("td");//创建td
           		td1.innerHTML="<p name='leavetableuid' value='"+list[indax].uid+"' id='leavetableuid"+indax+"'>"+list[indax].uid+"</p>";
           		var td2 = document.createElement("td");//创建td
           		td2.innerHTML=list[indax].uname;
           		var td3 = document.createElement("td");//创建td
           		td3.innerHTML=list[indax].dep;
           		var td4 = document.createElement("td");//创建td
           		td4.innerHTML=list[indax].pos;
           		var td5 = document.createElement("td");//创建td
           		td5.innerHTML=list[indax].lnum;
           		var td6 = document.createElement("td");//创建td
           		td6.innerHTML=list[indax].lstart;
           		var td7 = document.createElement("td");//创建td
           		td7.innerHTML=list[indax].lend;
           		var td8 = document.createElement("td");//创建td
           		td8.innerHTML=list[indax].lend;
           		var td9 = document.createElement("td");//创建td
           		td9.innerHTML=list[indax].lreason;
           		var td10 = document.createElement("td");//创建td
           		td10.innerHTML="<input id='leavetable1addbut"+indax+"' type='button'  value='通过'  onclick='getUserLeave("+indax+")'></input><input id='leavetable1delbut"+indax+"' type='button'  value='删除'  onclick='delUserLeave("+indax+")'></input>";
           		
           		tr.appendChild(td1);
           		tr.appendChild(td2);
           		tr.appendChild(td3);
           		tr.appendChild(td4);
           		tr.appendChild(td5);
           		tr.appendChild(td6);
           		tr.appendChild(td7);
           		tr.appendChild(td8);
           		tr.appendChild(td9);
           		tr.appendChild(td10);
           		var listbody = document.getElementById("leavetable");
           		listbody.append(tr);
           		
           		
           		
           		
           	});
        		
              
        }
        
       	
    });
	
}
function getUserLeave(indax){
	//获取用户的个人请假审批表进行审批,通过并添加到出差表中	
	var leavetableuid=$("#leavetableuid"+indax).html();
	var r = confirm("确定要通过批准吗?!!");
	if(r==true){
	  $.ajax({
		    //几个参数需要注意一下
		        type: "POST",//方法类型
		        dataType: "json",//预期服务器返回的数据类型
		        url: "userservlet?xinxi=leavepass",//url
		        data: {"uid":uid,"leavetableuid":leavetableuid},
		        success: function (result) {
		        	getLeave();
		        		
		              
		        }
		        
		       	
		    });
	}
}
function delUserLeave(indax){
	//获取用户的个人请假审批表进行审批,不通过,删除审批表信息
	var leavetableuid=$("#leavetableuid"+indax).html();
	var r = confirm("确定要删除吗?!!");
	if(r==true){
	  $.ajax({
		    //几个参数需要注意一下
		        type: "POST",//方法类型
		        dataType: "json",//预期服务器返回的数据类型
		        url: "userservlet?xinxi=noleavepass",//url
		        data: {"leavetableuid":leavetableuid},
		        success: function (result) {
		        	getLeave();
		        		
		              
		        }
		        
		       	
		    });
	}
	
}
function queryLeave() {
    $.ajax({
    //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "userservlet?xinxi=queryleave",//url
        data: {"uid":uid},
        success: function (result) {
        	
        	//var list = $.parseJSON(result);
        	var list = result;
        	$("#queryleavetable").html($("#queryleavetablefirsttr"));
        	
        	$.each(list,function(indax,item){	
        		var bt =document.createElement("button"); 
        		 
        		var tr = document.createElement("tr");//创建tr
        		var td1 = document.createElement("td");//创建td
        		td1.innerHTML=list[indax].uid;
           		var td2 = document.createElement("td");//创建td
           		td2.innerHTML=list[indax].uname;
           		var td3 = document.createElement("td");//创建td
           		td3.innerHTML=list[indax].dep;
           		var td4 = document.createElement("td");//创建td
           		td4.innerHTML=list[indax].pos;
           		var td5 = document.createElement("td");//创建td
           		td5.innerHTML=list[indax].lnum;
           		var td6 = document.createElement("td");//创建td
           		td6.innerHTML=list[indax].lstart;
           		var td7 = document.createElement("td");//创建td
           		td7.innerHTML=list[indax].lend;
           		var td8 = document.createElement("td");//创建td
           		td8.innerHTML=list[indax].lday;
           		var td9 = document.createElement("td");//创建td
           		td9.innerHTML=list[indax].approvalday;
           		var td10 = document.createElement("td");//创建td
           		td10.innerHTML= list[indax].approvalpos;
           		var td11 = document.createElement("td");//创建td
           		td11.innerHTML= list[indax].lreason;
           		
           		tr.appendChild(td1);
           		tr.appendChild(td2);
           		tr.appendChild(td3);
           		tr.appendChild(td4);
           		tr.appendChild(td5);
           		tr.appendChild(td6);
           		tr.appendChild(td7);
           		tr.appendChild(td8);
           		tr.appendChild(td9);
           		tr.appendChild(td10);
           		tr.appendChild(td11);
           		var listbody = document.getElementById("queryleavetable");
           		listbody.append(tr);	
           	});    
        }	
    });
}
function queryTrip() {
    $.ajax({
    //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "userservlet?xinxi=querytrip",//url
        data: {"uid":uid},
        success: function (result) {
        	
        	//var list = $.parseJSON(result);
        	var list = result;
        	$("#querytriptable").html($("#querytriptablefirsttr"));
        	
        	$.each(list,function(indax,item){	
        		var bt =document.createElement("button"); 
        		 
        		var tr = document.createElement("tr");//创建tr
        		var td1 = document.createElement("td");//创建td
        		td1.innerHTML=list[indax].uid;
           		var td2 = document.createElement("td");//创建td
           		td2.innerHTML=list[indax].uname;
           		var td3 = document.createElement("td");//创建td
           		td3.innerHTML=list[indax].dep;
           		var td4 = document.createElement("td");//创建td
           		td4.innerHTML=list[indax].pos;
           		var td5 = document.createElement("td");//创建td
           		td5.innerHTML=list[indax].tnum;
           		var td6 = document.createElement("td");//创建td
           		td6.innerHTML=list[indax].tplace;
           		var td7 = document.createElement("td");//创建td
           		td7.innerHTML=list[indax].tstart;
           		var td8 = document.createElement("td");//创建td
           		td8.innerHTML=list[indax].tend;
           		var td9 = document.createElement("td");//创建td
           		td9.innerHTML=list[indax].tday;
           		var td10 = document.createElement("td");//创建td
           		td10.innerHTML=list[indax].approvalday;
           		var td11 = document.createElement("td");//创建td
           		td11.innerHTML= list[indax].approvalpos;
           		var td12 = document.createElement("td");//创建td
           		td12.innerHTML= list[indax].treason;
           		
           		tr.appendChild(td1);
           		tr.appendChild(td2);
           		tr.appendChild(td3);
           		tr.appendChild(td4);
           		tr.appendChild(td5);
           		tr.appendChild(td6);
           		tr.appendChild(td7);
           		tr.appendChild(td8);
           		tr.appendChild(td9);
           		tr.appendChild(td10);
           		tr.appendChild(td11);
           		tr.appendChild(td12);
           		var listbody = document.getElementById("querytriptable");
           		listbody.append(tr);	
           	});    
        }	
    });
}

</script>
</head>
<body>




<div class="header">
  <div class="top"> <img class="logo" src="images/hello/logo.jpg" />
    <ul class="nav">
      <li class="seleli"><a href="#">首页</a></li>
      <li><a href="#">个人中心</a></li>
      <li><a href="#">绩效管理</a></li>
      <li><a href="#">人事管理</a></li>
      <li><a href="#">薪酬管理</a></li>
    </ul>
  </div>
</div>

<div class="container">
  <div class="leftbar">
    <div class="lm01"> <img class="peptx" src="images/hello/tximg.jpg" />
      <div class="pepdet">
        <p class="pepname">${user.uname }</p>
        <p>${user.uname }</p>
        
      </div>
      <div class="clear"></div>
    </div>
    <div class="lm02">
      <div class="title"><img class="icon" src="images/hello/dataicon.jpg" />
        <h2>签到</h2>
      </div>
      	
 
      	<div class="detail">
      		<button class="layui-btn" onclick="sign()">签到</button><br>
			<button class="layui-btn" onclick="afterwork()">签退</button><br>
			<button class="layui-btn" onclick="nsign()">加班打卡</button><br>
			<button class="layui-btn" onclick="naw()">加班签退</button> 
		</div>
</fieldset>    </div>
    <div class="lm03">
      <div class="title"><img style="padding-right:5px;" class="icon" src="images/hello/weaicon.jpg" />
        <h2>天气</h2>
      </div>
      <div class="detail"> <iframe width="210" scrolling="no" height="70" frameborder="0" allowtransparency="true" src="//i.tianqi.com/index.php?c=code&id=2&color=%23&bgc=%23&bdc=%23&icon=1&py=yanshi1&num=1&site=12"></iframe> </div>
    </div>
  </div>
  
  
  
	<div>
	<table>
		<tr>
			<td><button class="layui-btn" value="1" id="user" onclick="queryUser()">用户基本信息</button></td>
			<td><button class="layui-btn" value="2" id="att" onclick="queryAtt()">考勤查询</button></td>
			<td><button class="layui-btn" value="3" id="wageplan" onclick="queryWPlan()">工资查询</button></td>
			<td><button class="layui-btn" value="4" id="staff" onclick="queryStaff()">员工录用信息表</button></td>
			<td><button class="layui-btn" value="5" id="tsleave" >员工请假</button></td>    
			<td><button class="layui-btn" value="6" id="tstrip"  >员工出差</button></td>
			<td><button class="layui-btn" value="7" id="queryuser">查看员工信息</button></td>
			<td><button class="layui-btn" value="8" id="leave" onclick="getLeave()">请假处理</button></td>
			<td><button class="layui-btn" value="9" id="trip" onclick="getTrip()">出差处理</button></td>
		</tr>
		<tr>
			<td><button class="layui-btn" value="1" id="queryleave" onclick="queryLeave()">查看请假信息</button></td>
			<td><button class="layui-btn" value="2" id="querytrip" onclick="queryTrip()">查看出差信息</button></td>
		</tr>
	</table>
	</div>
	
	
	
	<div id="userdiv">
		<table border="1" >
			<tr>
				<td>员工ID</td>
				<td><p id="uid"></td>
				<td>员工姓名</td>
				<td><p id="uname"></td>
				<td>用户类别</td>
				<td>${user.utype }</td>
				<td>性别</td>
				<td><p id="ugen"></td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td><p id="uborndate"></td>
				<td>民族</td>
				<td><p id="unational"></td>
				<td>身份证号</td>
				<td><p id="uidcard"></td>
				<td>所属部门ID</td>
				<td><p id="did"></td>
			</tr>
			<tr>
				<td>进入部门时间</td>
				<td><p id="sdate"></td>
				<td>职务代码</td>
				<td><p id="pid"></td>
				<td>职称</td>
				<td><p id="title"></td>
				<td>起薪日期</td>
				<td><p id="startdate"></td>
			</tr>
			<tr>
				<td>原单位</td>
				<td><p id="unito"></td>
				<td>原职称</td>
				<td><p id="unitt"></td>
				<td>原职务</td>
				<td><p id="unitp"></td>
				<td>学历</td>
				<td><p id="edu"></td>
			</tr>
			<tr>
				<td>毕业学校</td>
				<td><p id="gschool"></td>
				<td>毕业日期</td>
				<td><p id="gdate"></td>
				<td>专业</td>
				<td><p id="pro"></td>
				<td>外语</td>
				<td><p id="lan"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><p id="phone"></td>
				<td>邮箱</td>
				<td><p id="email"></td>
				<td>籍贯</td>
				<td><p id="unplace"></td>
			</tr>
			<tr>
				<td>地址</td>
				<td colspan="5"><p id="add"></td>
			</tr>
		</table>
	</div>
	<div id="attdiv">
		<table  border="1" id ="atttable">
			<tr>
				<td>日期ID</td>
				<td>用户ID</td>
				<td>考勤生成日期</td>
				<td>考勤类型</td>
				<td>签到天数</td>
				<td>加班天数</td>
				<td>缺勤天数</td>
				<td>迟到天数</td>
				<td>请假天数</td>
				<td>备注</td>
				<td>姓名</td>
			</tr>
			
		</table>
	
	</div>
	<div id="wplandiv">
		<table id= "wplantable" border="1">
			<tr>
				<td>工资计发日期ID</td>
				<td>员工ID</td>
				<td>工资等级ID</td>
				<td>底薪</td>
				<td>补贴</td>
				<td>奖金</td>
				<td>车补</td>
				<td>房补</td>
				<td>扣考核</td>
				<td>加班费</td>
				<td>代扣养老金</td>
				<td>代扣医疗保险</td>
				<td>代扣住房公积金</td>
				<td>税前小计</td>
				<td>所得税</td>
				<td>应发工资</td>
				<td>计发日期</td>
			</tr>
		</table>
	</div>
	<div id="staffdiv">
		<table border="1" id = "stafftable">
			<tr>
				<td>签约合同号</td>
				<td>员工ID</td>
				<td>姓名</td>
				<td>签约日期</td>
				<td>合同到期日期</td>
				<td>合同类型</td>
				<td>受聘部门</td>
				<td>受聘职务</td>
				<td>受聘标志</td>
				<td>备注</td>
			</tr>
		</table>
	</div>
<div id="tsleavediv">
 <form id="tsleaveform" name="reg_testdate"  >
 	<table>
 	<tr>
 		<td>
 			请假天数
 		</td>
 		<td>
 			<select name="lnum">
 				<option value="1">1</option>
 				<option value="2">2</option>
 				<option value="3">3</option>
 				<option value="4">4</option>
 				<option value="5">5</option>
 				<option value="6">6</option>
 				<option value="7">7</option>
 				<option value="99">长期</option>
 			</select>
 		</td></tr>
 	<tr>
 		<td>
 			请假开始日期
 		</td>
 		<td>
 			<select name="YYYY" onchange="YYYYDD(this.value)">
   							<option value="1970">请选择 年</option>
 					 	</select>
  						<select name="MM" onchange="MMDD(this.value)">
    						<option value="1">选择 月</option>
  						</select>
  						<select name="DD">
    						<option value="1">选择 日</option>
  						</select>
 		</td>
 	</tr>
 	<tr>
 		<td>请假结束时间</td>
 		<td><select name="YYYYY" onchange="YYYYDD(this.value)">
   							<option value="1970">请选择 年</option>
 					 	</select>
  						<select name="MMM" onchange="MMDD(this.value)">
    						<option value="1">选择 月</option>
  						</select>
  						<select name="DDD">
    						<option value="1">选择 日</option>
  						</select></td>
 	</tr>
 	<tr>
 		<td>请假原因</td>
 		<td><input type="text" name="lreason"></td>	
 	</tr>
 	</table>
	
	</form>
	<button onclick="getTsLeave()">确定提交</button>
</div>
<div id="tstripdiv">
	 <form id="tstripform"  >
 	<table>
 	<tr>
 		<td>
 			出差天数
 		</td>
 		<td>
 			<select name="tnum">
 				<option value="1">1</option>
 				<option value="2">2</option>
 				<option value="3">3</option>
 				<option value="4">4</option>
 				<option value="5">5</option>
 				<option value="6">6</option>
 				<option value="7">7</option>
 				<option value="99">长期</option>
 			</select>
 		</td></tr>
 	<tr>
 		<td>
 			出差开始日期
 		</td>
 		<td>
 			<div class="layui-form">
  				<div class="layui-form-item">
   					<div class="layui-inline">
      					<div class="layui-input-inline">
        					<input  name="tstart" type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd">
      					</div>
   					</div> 
  				</div>
			</div>
 		</td>
 	</tr>
 	<tr>
 		<td>出差结束时间</td>
 		<td>
 			<div class="layui-form">
  				<div class="layui-form-item">
    				<div class="layui-inline">
    				  	<div class="layui-input-inline">
      					  <input name="tend" type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd">
     					</div>
   					 </div> 
 				 </div>
			</div>
 		</td>
 	</tr>
 	<tr>
 		<td>出差地</td>
 		<td><input type="text" name="tplace"></td>	
 	</tr>
 	<tr>
 		<td>出差原因原因</td>
 		<td><input type="text" name="treason"></td>	
 	</tr>
 	</table>
	
	</form>
	<button	 onclick="getTsTrip()">确定提交</button>

</div>

<div id="queryuserdiv">
	<form action="">
		<table border="0" >
			<tr>
			<td>ID</td>
			<td><input type="text" name="quid" id="quid"></td>
			<td>姓名</td>
			<td><input type="text" name="quname" id="quname"></td>
			<td>部门</td>
			<td>
				<select name="qdname" id="qdname">
					<option>不限制</option>
					<option>人事部</option>
					<option>财务部</option>
					<option>技术部</option>
					<option>营销部</option>
					<option>后勤部</option>
					<option>生产部</option>
					<option>质检部</option>
				</select>
			</td>
			<td>职务</td>
			<td>
				<select name="qpname" id="qpname">
					
				</select>
			</td>
			<td>是否在出差</td>
			<td>
				<select name="qtrip" id="qtrip">
					<option>不限制</option>
					<option>是</option>
					<option>否</option>
				</select>
			</td>
			<td>是否在请假</td>
			<td>
				<select name="qleave" id="qleave">
					<option>不限制</option>
					<option>是</option>
					<option>否</option>
				</select>
			</td>
		</tr>
		</table>
	</form>
	<button id="subquser" onclick="queryUserDP()">提交查询</button>
	<table border="1" id="queryusertable">
		<tr id="queryusertablefirsttr">
			<td>用户ID</td>
			<td>用户姓名</td>
			<td>用户类型</td>
			<td>住址</td>
			<td>电话</td>
			<td>邮箱</td> 
			<td>部门</td>
			<td>职务</td>
			<td>是否请假</td>
			<td>是否出差</td>
		</tr>
		
	</table>
	
</div>


<div id="tripdiv">
	<table border="1" id="triptable1">
		<tr id="triptable1firsttr">
			<td>员工ID</td>
			<td>员工姓名</td>
			<td>部门</td>
			<td>职务</td>
			<td>出差天数</td>
			<td>出差地</td>
			<td>开始时间</td>
			<td>结束时间</td>
			<td>申请日期</td>
			<td>出差原因</td>
			<td>处理</td>
		</tr>
	</table>
</div>
<div id="leavediv">
	<table border="1" id="leavetable">
		<tr id="leavetablefirsttr">
			<td>员工ID</td>
			<td>员工姓名</td>
			<td>部门</td>
			<td>职务</td>
			<td>请假天数</td>
			<td>开始时间</td>
			<td>结束时间</td>
			<td>申请日期</td>
			<td>请假原因</td>
			<td>处理</td>
		</tr>
	</table>
</div>
<div id="queryleavediv">
	<table border="1" id="queryleavetable">
		<tr id="queryleavetablefirsttr">
			<td>员工ID</td>
			<td>员工姓名</td>
			<td>部门</td>
			<td>职务</td>
			<td>请假天数</td>
			<td>开始时间</td>
			<td>结束时间</td>
			<td>申请日期</td>
			<td>批准时间</td>
			<td>批准人</td>
			<td>请假原因</td>
		</tr>
	</table>
</div>
<div id="querytripdiv">
	<table border="1" id="querytriptable">
		<tr id="querytriptablefirsttr">
			<td>员工ID</td>
			<td>员工姓名</td>
			<td>部门</td>
			<td>职务</td>
			<td>出差天数</td>
			<td>出差地</td>
			<td>开始时间</td>
			<td>结束时间</td>
			<td>申请日期</td>
			<td>批准时间</td>
			<td>批准人</td>
			<td>出差原因</td>
		</tr>
	</table>
</div>
<table class="layui-hide" id="test"></table>
</body>
</html>