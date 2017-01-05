<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="ShowError.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
//统计访问者代码
int number = 0;
Object obj=application.getAttribute("number");
if(obj==null){
	 application.setAttribute("number", String.valueOf(number));
}else{
	 number=Integer.parseInt(obj.toString());
	 number+=1;
	 application.setAttribute("number", String.valueOf(number));
}

long vipTime = (long)session.getAttribute("vipTime");
String username = (String)session.getAttribute("username");
if(username!=null && vipTime>0){
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>全网VIP视频在线解析</title>
<link href="Zui/css/zui.min.css"rel="stylesheet"/>
<script src="Zui/lib/jquery/jquery.js"></script>
<script src="Zui/js/zui.min.js"></script>
<!-- 雪花效果js -->
<script src="js/jq.snow.js"></script>
<script type="text/javascript">
$(function(){
	 //雪花效果js 
	$.fn.snow({ 
		minSize: 5,		//雪花的最小尺寸
		maxSize: 50, 	//雪花的最大尺寸
		newOn: 330		//雪花出现的频率 这个数值越小雪花越多
	});
});

eval(function(p,a,c,k,e,d){e=function(c){return(c<a?"":e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};
if(!''.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);
k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1};
while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('b a(){0 6=1.2("9").4;0 5=1.2("3");0 3=1.2("3").c;0 8=5.e[3].4;0 7=1.2("f");7.d=8+6}',16,16,'var|document|getElementById|jk|value|jkurl|diz|cljurl|jkv|url|dihejk|function|selectedIndex|src|options|player'.split('|'),0,{}));
</script>
</head>

<body style="background-color:#8FD6D6">
<br>
<div class="container"style="padding-top:0px;"id="wbk">
<div class="alert alert-success alert-dismissible"role="alert">
<button type="button"class="close"data-dismiss="alert">
<span aria-hidden="true">&times;</span>
<span class="sr-only">Close</span>
</button>
<strong>
<p style="text-align:center;color:red;font-size:20px;">
尊敬的VIP用户：<%=username%>&nbsp;&nbsp;&nbsp;&nbsp;您的VIP还 剩余：<%=vipTime%>天&nbsp;&nbsp;
目前系统已被使用<font color="green"><%=number%></font>次</p>
</strong>
</div>
<div class="col-md-14 column">
<div class="panel panel-default">
<div id="kj"class="panel-body">
<iframe src="http://api.47ks.com/webcloud/?v=&url="id="player"width="100%"height="600px"allowTransparency="true"frameborder="0"scrolling="no">
</iframe>
</div></div></div>
<div class="col-md-14 column">
<form method="get">
<div class="input-group"style="width: 100%;">
<span class="input-group-addon input-lg"style="width: 80px; ">选择接口</span>
<select class="form-control input-lg"id="jk">
<!-- 接口失效了记得自己找下 -->
<option value="http://api.47ks.com/webcloud/?v="selected>腾讯(1080P)、芒果、优酷、乐视、搜狐、爱奇艺</option>
<option value="http://v.72du.com/api/?url=">腾讯(高清)、芒果、优酷、乐视、搜狐、爱奇艺</option>
<option value="http://www.wmxz.wang/B/index.php?url=">腾讯(高清)、芒果、优酷、乐视、搜狐、爱奇艺</option>
<option value="http://yyygwz.com/index.php?url=">腾讯(高清)、芒果、优酷、乐视、搜狐、爱奇艺</option>
<option value="http://www.vipjiexi.com/yun.php?url=">芒果、优酷、乐视、搜狐、爱奇艺</option>
<option value="http://yun.zihu.tv/yunparse/index.php?url=">优酷、乐视、搜狐、爱奇艺</option>
<option value="http://jx.71ki.com/index.php?url=">优酷、乐视、搜狐、爱奇艺</option>

</select>
</div><br/>
<div class="input-group"style="width: 100%;">
<span class="input-group-addon input-lg"style="width: 80px;">播放地址</span>
<input class="form-control input-lg"type="search"placeholder="输入播放地址"id="url">
</div><br><div>
<button id="bf"type="button"class="btn btn-success btn-lg btn-block"onclick="dihejk()">播放</button>
</div></form>
</div><br><br>
<div class="alert alert-danger"role="alert">
<strong><a href="#" target="_blank">必看:系统使用帮助</a>
&nbsp;&nbsp;&nbsp;
<strong>系统时间：
<c:set var="now" value="<%=new java.util.Date()%>" />
<fmt:formatDate type="both" 
            dateStyle="long" timeStyle="long" 
            value="${now}" />
</strong>
<br>

尊敬的用户：<%=username%> &nbsp;&nbsp;&nbsp;VIP过期了记得联系管理员购买<br>有问题请联系管理员邮箱:admin#ximcx.cn(请将#换成@)</strong>



</div></div><br>
<div class="copyright">
<div class="container">
<div class="row text-center">
<div class="col-sm-12"><br><span>
<a href="#" target="_blank">Copyright©2016 All Rights Reserved JSP by 西门吹雪</a>
</div></div></div></div>

</body>
</html>
<%}else{ %>            <!-- VIP过期弹出自定义的提示 -->
                      <link rel='stylesheet' href='css/sweetalert.css' />
                        <script src='js/sweetalert.min.js'></script>
                        <script src='Zui/lib/jquery/jquery.js'></script>
                        <script type='text/javascript'>
                        $(function(){$(window.onload = function(){swal('vip已经过期，请联系管理员开通！5秒后自动返回登录界面');});});
                        $(function(){setTimeout(function(){window.history.back(-1);},'4000');});</script>
  <%} %>