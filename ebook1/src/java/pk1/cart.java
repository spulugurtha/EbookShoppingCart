/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1;

import java.io.*;
import java.sql.*;


import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author sarat
 */
public class cart extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body background=\"fondl.JPG\">");
        HttpSession session1=request.getSession();
        String uname=(String)session1.getAttribute("uname");
        String x = request.getParameter("book");
        String y = request.getParameter("price");
        String z = request.getParameter("qty");

        //int a = Integer.parseInt(y);
        //int b = Integer.parseInt(z);
        //String c="SYSDATE";
int flag;
        //int amt = (a*b);

        try {
            Driver d = new sun.jdbc.odbc.JdbcOdbcDriver();
            DriverManager.registerDriver(d);
            Connection con = DriverManager.getConnection("jdbc:odbc:it47", "hr", "hr");
            //Statement st = con.createStatement();
            
            Statement s= con.createStatement();
            String sql="select qty from catalog where username=\"uname\";
                                      if( x== rs.getString(1))
                                      {
                                         flag==1;
                                       
                                      }
            
            PreparedStatement pstmt = con.prepareStatement("insert into catalog values(?,?,?,?,?)");
            pstmt.setString(1, x);
            pstmt.setInt(2, Integer.parseInt(y));
            pstmt.setInt(3, Integer.parseInt(z));
            pstmt.setInt(4, Integer.parseInt(y) * Integer.parseInt(z));
            pstmt.setString(5, uname);
            pstmt.executeUpdate();


            // out.println("values are entered ");
            out.println("values are added to cart");
            out.println("<form action=\"cat\" method=\"get\">");
            out.println("<input type=\"submit\" value=\"view here\">");
            out.println("<center><a href=\"catalog.html\"><img height=\"100\" src=\"catlog.jpg\"></a><br><h1>book catalogue</h1></center>");
            out.println("<h3 align=\"right\"><a href=\"logout.jsp\">LOGOUT</a></h3>");
            // out.println("<a href=\"logout.jsp\">logout</a>");
             out.println("</form>");
             out.println("</body></html>");
        } catch (Exception e) {
            response.sendError(500, e.toString());
        }
    }
}

    
    
    