package com.video.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.Bean.User;
import com.video.Database.AllMethod;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet() {
        super();
         
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
		  //防止出现乱码
	                               request.setCharacterEncoding("UTF-8");  
	                               response.setCharacterEncoding("UTF-8");  
	                               response.setContentType("text/html; charset=utf-8");  
           //这里是百度到的强转代码，用第二种方式会报错
	                               int id= Integer.parseInt(request.getParameter("id"));
	                               //int id = request.getParameter("id");  
	                               String username = request.getParameter("username");
	                               String passwd = request.getParameter("passwd");
	                               String time = request.getParameter("time");
	                               String beizhu = request.getParameter("beizhu");
	      //实例化一个User属性类对象，把传过来的数据加进去
	                               User user = new User();
	                                    user.setId(id);
	                                    user.setUsername(username);
	                                    user.setPasswd(passwd);
	                                    user.setTime(time);
	                                    user.setBeizhu(beizhu);
	                               AllMethod up = new AllMethod();//实例化一个所有方法的对象
	                                         up.Up(user);//将数据添加到方法中
		                                  
		                                  
	                               RequestDispatcher going = request.getRequestDispatcher("admin/alluser.jsp");
	                               going.forward(request, response);	                                  
		                                  
		                                  
	}

}
