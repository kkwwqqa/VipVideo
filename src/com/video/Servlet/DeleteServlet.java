package com.video.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.Database.AllMethod;



 

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DeleteServlet() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		                         
		
     
		//防止出现乱码
                               request.setCharacterEncoding("UTF-8");  
                               response.setCharacterEncoding("UTF-8");  
                               response.setContentType("text/html; charset=utf-8");  


                               String id = request.getParameter("id");  
                               AllMethod function = new AllMethod();//实例化一个所有方法的对象
                                       function.Del(id);
     
      //PrintWriter out = response.getWriter();调试BUG残留的
      //out.println(id);调试BUG残留的
                                 RequestDispatcher going = request.getRequestDispatcher("admin/alluser.jsp");
                                 going.forward(request, response);
		 
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	                    
	}

}
