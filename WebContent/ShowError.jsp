<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>出错啦~~</title>
</head>
<body>
 <!-- 系统出错自定义的提示 -->
 
                      <link rel='stylesheet' href='css/sweetalert.css' />
                        <script src='js/sweetalert.min.js'></script>
                        <script src='Zui/lib/jquery/jquery.js'></script>
                        <script type='text/javascript'>
                        $(function(){$(window.onload = function(){swal('出错了，请勿非法登录！');});});
                        $(function(){setTimeout(function(){window.history.back(-1);},'1000');});
                        </script>
</body>
</html>