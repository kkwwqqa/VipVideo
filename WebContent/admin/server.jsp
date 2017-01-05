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
if(adminname!=null && adminname.equals(ChekAdminUser.getAdminname())){%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${PATH}/css/css.css" />
<!-- ZUI 标准版压缩后的 CSS 文件 -->
<link rel="stylesheet" href="${PATH}/Zui/css/zui.min.css">
<!-- ZUI Javascript 依赖 jQuery -->
<script src="${PATH}/Zui/lib/jquery/jquery.js"></script>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
<script src="${PATH}/Zui/js/zui.min.js"></script>
<title>服务器信息</title>
</head>
<body>

<div class="alert alert-success"><span class="label label-success">服务器地址</span><b>：<%=request.getLocalAddr() %></b><br></div>
<div class="alert alert-success"><span class="label label-success">服务器名字</span><b>：<%=request.getServerName() %></b><br></div>
<div class="alert alert-success"><span class="label label-success">服务器端口</span><b>：<%=request.getServerPort() %></b><br></div>
<div class="alert alert-success"><span class="label label-danger">管理员用户名</span><b>：<%=session.getAttribute("adminname") %></b><br></div>
<div class="alert alert-success"><span class="label label-danger">系统总会员数</span><b>：<%=session.getAttribute("sqlalluser") %>人</b><br></div>
<div class="alert alert-success"><span class="label label-success">客户端的UA</span><b>：<%=request.getHeader("User-agent") %></b><br></div>
<div class="alert alert-success"><span class="label label-success">客户端的地址</span><b>：<%=request.getRemoteHost() %></b><br></div>
<%} %>
</body>
</html>