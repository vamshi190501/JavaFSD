package com.wiprosimplilearn.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		String id= request.getParameter("uid");
		PrintWriter out = response.getWriter();
		Properties props = new Properties();
		response.setContentType("text/html");
		
		
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);

		Connection conn = DBConfig.getConnection(props);

		if (conn != null) {
			out.print("Connection is Established");
			
			try {
				PreparedStatement stmt=conn.prepareStatement("select * from eproduct where ID = ?");
				stmt.setString(1,id);
				ResultSet rs= stmt.executeQuery();
				ResultSetMetaData rsmd=rs.getMetaData();
				out.print("<table width=25% border=1>");

                out.print("<center><h1>Result:</h1></center>");


                 while(rs.next())

                    {

                 out.print("<tr>");
                 
                    out.print("<td>"+rsmd.getColumnName(1)+"</td>");

                    out.print("<td>"+rs.getString(1)+"</td></tr>");

                    out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
                    
                    out.print("<td>"+rs.getString(2)+"</td></tr>");
                    
                    out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");

                    out.print("<td>"+rs.getString(3)+"</td></tr>");
                    
                    out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");

                    out.print("<td>"+rs.getString(4)+"</td></tr>");                  

                 }

                 out.print("</table>");



          }catch (Exception e2)

            {

                e2.printStackTrace();

            }
		}
			
          else {
  			out.print("Error while connecting connection");
  		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
