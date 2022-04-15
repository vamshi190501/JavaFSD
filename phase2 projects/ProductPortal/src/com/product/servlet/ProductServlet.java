package com.product.servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
  
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
    throws ServletException, IOException
    {
     response.setContentType("text/html;charset=UTF-8");
     try (PrintWriter out = response.getWriter()) {
       out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>Servlet ProductServlet</title>");
       out.println("</head>");
       out.println("<body>");
  
       // List to hold Student objects
       ArrayList<Product> std = new ArrayList<Product>();
  
       // Adding members to the list. Here we are 
       // using the parameterized constructor of 
       // class "Student.java"
       std.add(new Product(1,"Lenevo" ,10000));
       std.add(new Product(2,"Asus",20000));
       std.add(new Product(3,"Dell",30000));
       std.add(new Product(4,"HP",40000));
       std.add(new Product(5,"Acer",50000));
  
       // Setting the attribute of the request object
       // which will be later fetched by a JSP page
         request.setAttribute("data", std);
  
       // Creating a RequestDispatcher object to dispatch
       // the request the request to another resource
         RequestDispatcher rd = 
             request.getRequestDispatcher("product/prolist.jsp");
  
       // The request will be forwarded to the resource 
       // specified, here the resource is a JSP named,
       // "stdlist.jsp"
          rd.forward(request, response);
            out.println("</body>");
            out.println("</html>");
        }
    }
    /** Following methods are used to handle
        requests coming from the Http protocol request.
        Inspects method of HttpMethod type
        and if the request is a POST, the doPost() 
        method will be called or if it is a GET,
        the doGet() method will be called. 
    **/
    @Override
    protected void doGet(HttpServletRequest request,
                        HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}
