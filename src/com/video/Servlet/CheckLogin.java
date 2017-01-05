package com.video.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.video.Bean.Chek;
import com.video.Bean.User;
import com.video.CheckTime.CheckTime;
import com.video.Database.AllMethod;


 

public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CheckLogin() {
             super();
         
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//防止出现乱码
		           request.setCharacterEncoding("UTF-8");  
		           response.setCharacterEncoding("UTF-8");  
		           response.setContentType("text/html; charset=utf-8");  
	//从前台获取用户名和密码
		          String username = request.getParameter("username"); 
		          String passwd = request.getParameter("passwd");
		          
		          User user = new User();
		          user.setUsername(username);
		          user.setPasswd(passwd);
		            
		          
		         AllMethod login = new AllMethod();//实例化一个所有方法的对象
		         CheckTime cktime = new CheckTime();//实例化一个时间处理对象
		         Chek ck = login.CheckLogin(user);//得到CheckLogin返回的结果集
	//调用User里面的getTime方法，因为在CheckLogin方法里已经setTime了	         
		         String time = ck.getTime();
		         
		       
		         
		         
		               
	if(ck.isChek()){
//如果调用的值为true就登录成功，把用户名和VIP剩余时间存起来发送到前台。。
		          HttpSession session = request.getSession();
		          session.setAttribute("username", username);//把用户名存起来
		         
		          
		          try {
		        	  /*
		        	   * 系统貌似必须要用try，catch包起来~~~~~
		        	   */
					session.setAttribute("vipTime",cktime.Chek(time));
					
				} catch (ParseException e){e.printStackTrace();}
		          

		         RequestDispatcher going = request.getRequestDispatcher("user.jsp");
		         
		         going.forward(request, response);
		          
		               }else{
		            	   
		            	   
	//登录失败，利用js代码弹窗提示后返回前面页面
		            	   PrintWriter out = response.getWriter();
	
		            	   
                        out.print("<link rel='stylesheet' href='css/sweetalert.css' />");
                        out.print("<script src='js/sweetalert.min.js'></script>");
                        out.print("<script src='Zui/lib/jquery/jquery.js'></script>");
                        out.print("<script type='text/javascript'>$(function(){$(window.onload = function(){swal('账号或密码错误!5秒后自动返回');});});");
                        out.print("$(function(){setTimeout(function(){window.history.back(-1);},'2300');});</script>");
		            	   
		            	   
		            	   
     //测试BUG的残留，不想删除了。out.println("<script type='text/javascript'>alert('账号或密码错误！');window.history.back(-1);</script>" );
		            	   
		               }
		
	}

}
