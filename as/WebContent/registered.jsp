<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script language="JavaScript">   
   function YYYYMMDDstart()   
   {   
           MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];   
    
           //先给年下拉框赋内容   
           var y  = new Date().getFullYear();   
           for (var i = (y-70); i < (y+1); i++) 
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
   </script>
</head>
<body>
	<div>
		<form action="userservlet?xinxi=3" method="post" name="reg_testdate">
			<table border="1">
				<tr>
					<td>性别</td>
					<td><select name="ugen"><option  value="男" >男<option value="女">女</select></td>
					<td>民族</td>
					<td><select name="unational"><option value="汉">汉</select></td>
					<td>外语</td>
					<td><input type="text" name="lan"></td>
				</tr>
				<tr>
					<td>民族</td>
					<td><input type="text" name=""></td>
					<td>政治面貌</td>
					<td><input type="text" name="upl"></td>
					<td>职称</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>原单位</td>
					<td><input type="text" name="unito"></td>
					<td>原职称</td>
					<td><input type="text" name="unitt"></td>
					<td>原职务</td>
					<td><input type="text" name="unitp"></td>
				</tr>
				<tr>
					<td>毕业学校</td>
					<td><input type="text" name="gschool"></td>
					<td>学历</td>
					<td><input type="text" name="edu"></td>
					<td>专业</td>
					<td><input type="text" name="pro"></td>
				</tr>
				<tr>
					<td>出生日期</td>
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
					<td>籍贯</td>
					<td colspan="3"><input name="unplace" type="text"></td>
				</tr>
				<tr>
					<td>应聘部门</td>
					<td>
						<select name = "dep">
							<option valer="人事部" >人事部
							<option valer="财务部" >财务部
							<option valer="技术部">技术部
							<option valer="营销部" >营销部
							<option valer="后勤部" >后勤部
							<option valer="生产部" >生产部
							<option valer="质检部" >质检部
						</select>
					</td>
					<td>应聘职务</td>
					<td>
						<select name="pos">
							<option valer="部长">部长
							<option valer="主管" >主管
							<option valer="组长" >部长
							<option valer="资深员工">资深员工
							<option valer="员工" >员工
							<option valer="临时员工">临时员工
						</select>
					</td>
				</tr>
				<tr>
					<td>地址</td>
					<td colspan="5"><input type="text" name="add"></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>