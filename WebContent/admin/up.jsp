<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="ShowError.jsp" %>   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- 使用JSTL获取项目名字 -->   
<c:set var="PATH" value="${pageContext.request.contextPath}" /> 
<!-- 把后台账号密码封装的类调出来，方便每个页面做判断 --> 
     <jsp:useBean id="ChekAdminUser" class="com.video.Bean.Admin" scope="page" />
<% 
//严格判断用户是否登录开始
String adminname = (String)session.getAttribute("adminname");
if(adminname!=null && adminname.equals(ChekAdminUser.getAdminname())){
	//获取找到的id信息
int id = (int)request.getAttribute("id");
String username = (String)request.getAttribute("username");
String passwd = (String)request.getAttribute("passwd");
String time = (String)request.getAttribute("time");
String beizhu = (String)request.getAttribute("beizhu");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- ZUI 标准版压缩后的 CSS 文件 -->
<link rel="stylesheet" href="${PATH}/Zui/css/zui.min.css">
<!-- 日期插件需要的 CSS 文件 -->
<link rel="stylesheet" href="${PATH}/Zui/lib/datetimepicker/datetimepicker.css">
<!-- 自己定义的 CSS 文件 -->
<link rel="stylesheet" href="${PATH}/css/css.css">
<!-- ZUI Javascript 依赖 jQuery -->
<script src="${PATH}/Zui/lib/jquery/jquery.js"></script>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
<script src="${PATH}/Zui/js/zui.min.js"></script> 
<!-- 日期插件需要的JS 文件 -->
<script src="${PATH}/Zui/lib/datetimepicker/datetimepicker.js"></script>
<title>添加用户</title>
<script type="text/javascript">
v

	function chekUser(){
        var uName = document.getElementById("userName").value.trim();
        
        var patt = /^\S{3,20}$/;
      
        if (patt.test(uName)) {
     
            return true;
            
        } else {
           
//点击按钮时显示漂浮消息
// 创建 Messger 实例
var msg = $.zui.messager.show('　　骚年,用户名不能为空而且长度为3-20个字符之间！　　', {placement: 'top'});
document.myform.username.value="";
document.myform.passwd.value="";
document.myform.time.value="";
            return false;
        }
            
    }
		function chekPwd(){
			
        var Pwd = document.getElementById("userPassWd").value.trim();
        
       var patt = /^\S{3,30}$/;
      
        if (patt.test(Pwd)) {
        	
            return true;
            
        } else {
           

         var msg = $.zui.messager.show('　　骚年,密码不能为而且长度为3-30个字符之间！　　', {placement: 'top'});
         document.myform.passwd.value="";
         document.myform.time.value="";
         document.myform.beizhu.value="";
            return false;
        }
            
    }
	
	function chekAll() {
       if (!chekUser() || !chekPwd()) {
       	
            return false;
            
        }else{
        	
            return true;
        }
       
    }
	


</script>
</head>
<body>

<div class="add">
<form action="${PATH}/up.do" method="post" onsubmit="return chekAll()" name="myform">
<input type="hidden" value="<%=id%>" name="id">
<p class="add-p"><b>用户名:</b></p><br><input type="text" class="form-control" placeholder="请输入一个用户名" value="<%=username%>"id="userName" name="username" onblur="Ajax()">
<br><br>
<p class="add-p"><b>用户密码：</b></p><br><input type="text" class="form-control" placeholder="请输入用户的密码" value="<%=passwd%>" id="userPassWd" name="passwd">
<br><br>
<p class="add-p"><b>VIP到期时间：</b></p><br><input type="text" class="form-control form-date" placeholder="选择或者输入一个日期：年-月-日" value="<%=time%>" id="dateTime" name="time">
<br><br>
<p class="add-p"><b>用户备注：</b></p><br><input type="text" class="form-control" placeholder="默认备注是无" value="<%=beizhu%>" name="beizhu">
<br>
 <button class="btn btn-block btn-primary" type="submit">点击更新</button>

</form>
</div>
</body>
</html>

         <script type="text/javascript">
       // 仅选择日期
          $(".form-date").datetimepicker(
          {
              language:  "zh-CN",
              weekStart: 1,
              todayBtn:  1,
              autoclose: 1,
              todayHighlight: 1,
              startView: 2,
              minView: 2,
              forceParse: 0,
              format: "yyyy-mm-dd"
          });

        </script>
<%} %>
