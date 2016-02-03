package pk1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
         pw.println("<html><body background=\"fondl.JPG\">");

        //String name = request.getParameter("name");
       // String address = request.getParameter("address");
       // String phno = request.getParameter("phno");
        String username = request.getParameter("id");
        String password = request.getParameter("pass");
       // pw.println(password);
        //String act = request.getParameter("act");
        //int no = Integer.parseInt(request.getParameter("phno"));
        //if (act.equals("Submit")) {
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
                if (flag == 1) {
                    pw.println("SORRY INVALID ID,ID ALREADY  EXITS TRY AGAIN WITH NEW ID<br><br>");
                    pw.println("<a href=\"registration.html\">press REGISTER to RETRY</a>");
                } else {
                    PreparedStatement stmt1 = con.prepareStatement("insert into login values(?,?)");
                    stmt1.setString(1, username);
                    stmt1.setString(2, password);
                    //stmt1.setString(3, name);
                    //stmt1.setString(4, address);
                    //stmt1.setString(5, phno);
                    stmt1.executeUpdate();
                    pw.println("YOUR  DETAILS ARE ENTERED<br><br>");
                    pw.println("<a href=\"login.html\">press LOGIN to login</a>");
                }
                pw.println("</body></html>");
            } catch (Exception e) {
                response.sendError(500, e.toString());
            }
        //}
    }
}