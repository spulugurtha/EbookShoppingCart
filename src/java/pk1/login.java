package pk1;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html><body background=\"fondl.JPG\">");
        String username = request.getParameter("id");
        String password = request.getParameter("pass");
        HttpSession session1 = request.getSession(true);
        session1.setAttribute("uname", username);
        //RequestDispatcher rd=request.getRequestDispatcher("cart");
        //rd.forward(request, response);
        try {
            Driver d = new sun.jdbc.odbc.JdbcOdbcDriver();
            DriverManager.registerDriver(d);
            Connection con = DriverManager.getConnection("jdbc:odbc:it47", "hr", "hr");
            Statement stmt = con.createStatement();
            String sqlstmt = "select username,password from login";
            ResultSet rs = stmt.executeQuery(sqlstmt);
            int flag = 0;
            while (rs.next()) {
                if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                pw.println("SORRY INVALID ID TRY AGAIN ID<br><br>");
                pw.println("<a href=\"login.html\">press LOGIN to RETRY</a>");
            } else {
                pw.println("<h1>VALID LOGIN ID</h1><br><br>");
                pw.println("<h3>");
                pw.println("<center>");
                pw.println("<a href=\"catalog.html\"><img height=\"100\" src=\"catlog.jpg\"></a><br<fontcolor=\"black\">BOOKS CATALOG</font></a><br><br>");
                 pw.print("</center>");
                //pw.println("<li><a href=\"order.html\"><fontcolor=\"black\">ORDER CONFIRMATION</font>  </a></li><br><br>");
                 pw.println("</h3><h4 align=\"right\">");
                pw.println("<a href=\"logout.jsp\"><fontcolor=\"black\">LOGOUT</font></a><br><br></h4>");

            }
            pw.println("</body></html>");
        } catch (Exception e) {
            response.sendError(500, e.toString());
        }
    }
}
