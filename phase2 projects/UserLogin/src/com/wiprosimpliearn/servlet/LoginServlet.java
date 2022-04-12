package com.wiprosimpliearn.servlet;

import java.io.IOException;

import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		
		
		
		String name= request.getParameter("name");
		String Password=request.getParameter("password");
		
		if(name.contentEquals("Vamshi") && Password.equals("2001")) {
			out.print("welcome "+name);
			HttpSession session=request.getSession();
			session.setAttribute("name",name);
			request.getRequestDispatcher("link.html").forward(request, response);
		}
		
		
		else
		{ 
			out.print("Invalid Credentials");
			request.getRequestDispatcher("login.html").include(request, response);
			
			
		}
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

