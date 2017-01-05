package com.video.Ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.Database.AllMethod;


public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();
        out.println("<response>");
 //实例化一个所有方法的对象       
        AllMethod all = new AllMethod();
        boolean isExists;
        isExists = all.findByUsername(username);
        
        
       if(isExists){
              out.println("<res>" + "用户名已存在" + "</res>");
       }else{
              out.println("<res></res>");
       }
       
        out.println("</response>");
        out.close();
	}

}
