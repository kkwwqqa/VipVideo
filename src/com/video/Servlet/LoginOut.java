package com.video.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public class LoginOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public LoginOut() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//传用户名过来设置成空就退出
		     
		//防止出现乱码
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html; charset=utf-8");
        

		               String adminname = "";     
		               HttpSession session = request.getSession();
		                session.setAttribute("adminname", adminname);

		            	   PrintWriter out = response.getWriter();
   
                             out.print("退出成功！");
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		                    
	}

}
