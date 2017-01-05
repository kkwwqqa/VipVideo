<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page errorPage="ShowError.jsp" %>    
<%@ page errorPage="ShowError.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!-- 使用JSTL获取项目名 -->     
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
<title>用户中心</title>
</head>
<body>


<!-- 网页开始 -->
       
 <div class="container"><!--整个大容器开始-->
 
       <div class="user"><!--自定义CSS布局开始-->

            <nav class="navbar navbar-default" role="navigation">
                 <div class="container-fluid">
                    <ul class="nav navbar-nav nav-justified">
                      <li><a href="#" onclick="wel();">欢迎管理员</a></li>
                      <li><a href="${PATH}/admin/add.jsp" target="showPage">添加会员</a></li>
                      <li><a href="${PATH}/admin/alluser.jsp" target="showPage">所有用户</a></li>
                      <li id="Sou"><a href="#"><i class="icon icon-search"></i>会员搜索</a></li>
                      <li><a href="${PATH}/admin/server.jsp" target="showPage">服务器信息</a></li>
                      
                       
                      <li><a href="${PATH}/LoginOut.do">退出</a></li>
                    </ul>
                  </div>
             </nav>
             
             
             
             <iframe id="showPage" noresize="noresize" name="showPage" width=1000px height=800px
			frameborder=0 scrolling=no src="${PATH}/admin/alluser.jsp"></iframe>
             
             </div><!--自定义CSS布局结束-->
             
       </div><!--整个容器结束-->


			
<script type="text/javascript">
/* 使用Javascript方法绑定在列表上触发搜索对话框 */
$('#Sou').modalTrigger({showHeader: false,custom:
'<p><form style="text-align: center;" action="sou" method="get"><input type="text" name="key" class="form-control" placeholder="请输入会员用户名或者ID"><button type="submit" class="btn btn-block btn-warning"><i class="icon icon-search"></i>戳我进行搜索</button></form></p><br>'});
function wel(){
	alert("欢迎管理员！");
	
}
</script>			

<%}else{//response.sendRedirect("admin/login.html");%>
<jsp:forward page="${PATH}/login.html" />

<% }//严格判断用户是否登录结束 %>
</body>
</html>