<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.io.*"%>
   <%@ page errorPage="ShowError.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<c:set var="PATH" value="${pageContext.request.contextPath}" /> <!-- 使用JSTL获取项目名字 -->
<!-- 把后台账号密码封装的类调出来，方便每个页面做判断 --> 
     <jsp:useBean id="ChekAdminUser" class="com.video.Bean.Admin" scope="page" />
<% 
//严格判断用户是否登录开始
String adminname = (String)session.getAttribute("adminname");
if(adminname!=null && adminname.equals(ChekAdminUser.getAdminname())){%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${PATH}/Zui/css/zui.min.css"rel="stylesheet"/>
<link rel="stylesheet" href="${PATH}/css/css.css" />
<style>
a:hover
{
background-color:#F0FFFF;
color:red;
font-size:16px;
}
</style>
<title>所有用户</title>

</head>
<body>
<table class="table table-hover">
<tr>
<td  class="success"><h4><b>用户ID</b></h4></td>
<td  class="success"><h4><b>用户昵称</b></h4></td>
<td  class="success"><h4><b>用户密码</b></h4></td>
<td  class="success"><b><h4>VIP到期时间</h4></b></td>
<td  class="success"><b><h4>用户备注</h4></b></td>
<td  class="success"><b><h4>操作用户</h4></b></td>
</tr>
<!-- 用javabaen把连接数据库类引进来 -->
<jsp:useBean id="con" class="com.video.Database.DatabaseCon" scope="page" />

<%
//防止出现乱码
          request.setCharacterEncoding("UTF-8");  
          response.setCharacterEncoding("UTF-8");  
          response.setContentType("text/html; charset=utf-8");  

//连接数据库
      Connection conn=con.getConnection();
      
	   String sql="select * from user";
	  PreparedStatement st = conn.prepareStatement(sql);
//执行查询	 
	 ResultSet rs=st.executeQuery();
//定义变量
	  String userId ="";
	  String userName ="";
	  String passWd ="";
	  String Time ="";
	  String Beizhu;
//循环输出数据，并且构造相关语句   
	   while(rs.next()){
		     userId=rs.getString("id");
		     userName=rs.getString("username");
		     passWd=rs.getString("passwd");
		     Time=rs.getString("time");
		     Beizhu=rs.getString("beizhu");
  %>

	<tr class='info'>
	<td><code><%=userId %></b></td>
	<td><b><%=userName%></a></b></td>
	<td><b><%=passWd%></b></td>
	<td><b><%=Time %></b></td>
	<td><b><%=Beizhu %></b></code></td>
	<td><a href="${PATH}/find.do?id=<%=userId %>">更新</a>-
	<a href="${PATH}/del.do?id=<%=userId %>">删除</a></span></td>

	</tr>
	
 <% 
                       }
                 rs.close();
	             st.close();
	             conn.close();

  %>

 </table>
 <%} %>
</body>
</html>