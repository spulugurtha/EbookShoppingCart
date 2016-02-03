

package pk1;

import java.io.*;
import java.sql.*;


import javax.servlet.*;
import javax.servlet.http.*;


public class cat extends HttpServlet {
   
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        HttpSession session1=request.getSession();
        String uname=(String)session1.getAttribute("uname");
        pw.println(uname);
        try
        {
            
        
        Driver d = new sun.jdbc.odbc.JdbcOdbcDriver();
                DriverManager.registerDriver(d);
                Connection con = DriverManager.getConnection("jdbc:odbc:it47", "hr", "hr");
                //Statement stmt = con.createStatement();
                //String sqlstmt = "select * from catalog";
                //ResultSet rs = stmt.executeQuery(sqlstmt);
                PreparedStatement pst=con.prepareStatement("select * from catalog where username=?");
                pst.setString(1, uname);
                ResultSet rs=pst.executeQuery();
               pw.println("<html> <body background=\"fondl.JPG\">");
                pw.println("<h3 align=\"right\"><a href=\"logout.jsp\">LOGOUT</a></h3>");
                  pw.println( "<table>");
                  pw.println("<tr><th>bookname</th><th>price</th><th>qty</th><th>amount</th></tr>" );
               // ResultSet rs = stmt.executeQuery(sqlstmt);
                  while(rs.next())
                  {
                      pw.println("<tr><td>");
                  pw.println(rs.getString(1));
                  pw.println("</td><td>" );
                  pw.println(rs.getInt(2));
                   pw.println("</td><td>" );
                  pw.println(rs.getInt(3));
                   pw.println("</td><td>" );
                  pw.println(rs.getInt(4) );
                   pw.println("</td></tr>" );
                  }               
                 pw.println("</table></body> </html>");
                 pw.println("<form action=\"order.html\" method=\"get\">");
            pw.println("<input type=\"submit\" value=\"ORDER\">");
            pw.println("<center><a href=\"catalog.html\"><img height=\"100\" src=\"catlog.jpg\"></a><br><h1>book catalogue</h1></center>");
            
             pw.println("</form>");
                 }
              catch (Exception e) 
              {
                response.sendError(500, e.toString());
            }
    }
}
