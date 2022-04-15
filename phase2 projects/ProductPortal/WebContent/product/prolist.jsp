<%@page import="com.product.servlet.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Product List</title>
  </head>
  <body>
      <h1>Displaying Product List</h1>
      <table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
          <th><b>Product Id</b></th>
          <th><b>Product Name</b></th>
          <th><b>Product price</b></th>
         </tr>
        <%-- Fetching the attributes of the request object
             which was previously set by the servlet 
              "ProductServlet.java"
        --%> 
        <%ArrayList<Product> std = 
            (ArrayList<Product>)request.getAttribute("data");
        for(Product s:std){%>
        <%-- Arranging data in tabular form
        --%>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getName()%></td>
                <td><%=s.getPrice()%></td>
            </tr>
            <%}%>
        </table> 
        <hr/>
    </body>
</html>