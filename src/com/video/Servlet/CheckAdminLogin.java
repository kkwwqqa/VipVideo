package com.video.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.video.Bean.Admin;
import com.video.Bean.User;
import com.video.Database.AllMethod;



public class CheckAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckAdminLogin() {
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
                              String adminname = request.getParameter("adminname"); 
                              String adminpasswd = request.getParameter("adminpasswd");
        //封装后台账号密码，便于管理和维护                    
                              Admin chekadmin = new Admin();
       //把从前台获取的账号密码与封装的账号密码做对比                   
                              if(adminname !=null
                            		  &&
                            		  adminname.equals(chekadmin.getAdminname())
                            		  &&
                            		  adminpasswd !=null && adminpasswd.equals(chekadmin.getAdminpwd())){
           //自定义一个后台账号密码。由于管理员的功能不是很多。所以不用建立数据库去做判断
                            	   HttpSession session = request.getSession();
                            	   session.setAttribute("adminname", adminname);
          //实例化一个所有方法的对象                 	   
                            	   AllMethod login = new AllMethod();
          //调用SQLall()方法，统计总会员人数，并且把总会员数存起来               	   
                            	   int sqlalluser = login.SQLall();
                            	   session.setAttribute("sqlalluser", sqlalluser);
       /*调用All()方法，得到所有用户集合后，进行转向
        * 我放弃了这种做法，因为多个Servlet无法做数据之间的交换，除非用Spring MVC框架(不会~~)
        * 所以查找所有用户的页面写用的是最原始的方法-把SQL写在页面中。
                           		AllMethod all = new AllMethod();//实例化一个所有方法的对象
                           		List<User> allusers =  all.All();    	   
                           	    request.setAttribute("allusers", allusers);
           */
                               RequestDispatcher going = request.getRequestDispatcher("admin/user.jsp");
                               going.forward(request, response);           	    
                            	  
                              }else{
              //还是利用js代码，登录失败就返回登录页面
                            	  PrintWriter out = response.getWriter();       		            	   
                                  out.print("<link rel='stylesheet' href='css/sweetalert.css' />");
                                  out.print("<script src='js/sweetalert.min.js'></script>");
                                  out.print("<script src='Zui/lib/jquery/jquery.js'></script>");
                                  out.print("<script type='text/javascript'>$(function(){$(window.onload = function(){swal('账号或密码错误!3秒后自动返回');});});");
                                  out.print("$(function(){setTimeout(function(){window.history.back(-1);},'2300');});</script>");                           	  
                            	  
                              }
	}

}
