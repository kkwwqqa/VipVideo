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






public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public AddServlet() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//防止出现乱码
		                request.setCharacterEncoding("UTF-8");  
		                response.setCharacterEncoding("UTF-8");  
		                response.setContentType("text/html; charset=utf-8");  
		
         //获取前面传过来的值
                       String username = request.getParameter("username");
                       String passwd = request.getParameter("passwd");
                       String time = request.getParameter("time");
                       String beizhu = request.getParameter("beizhu");
        //实例化一个用户(User)的javabean对象                 
                       User users =new User();
                       users.setUsername(username);
                       users.setPasswd(passwd);
                       users.setTime(time);
                       users.setBeizhu(beizhu);
       //实例化一个所有方法的对象              
                       AllMethod method = new AllMethod();
                              method.Add(users);
                      
        //转发数据
		 		         RequestDispatcher going = request.getRequestDispatcher("admin/alluser.jsp");
				         going.forward(request, response);
                       
		 
	}

}
