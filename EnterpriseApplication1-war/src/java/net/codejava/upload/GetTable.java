package net.codejava.upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/GetTable"})
public class GetTable extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>File information</title></head>");
    out.println("<body>");
    out.println("<center><h1>File information</h1>");
    Connection conn = null;
    Statement stmt = null;
    try {
     Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/IS_202", "root", "root");
      stmt = conn.createStatement();
      
      String query = "SELECT * from delivery";
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        int Delivery_ID = rs.getInt("Delivery_ID");
        String comment = rs.getString("Comment");
        Blob file = rs.getBlob("File");
        Boolean approved = rs.getBoolean("Approved");
        out.print(Delivery_ID + "::");
        out.print(comment + "::");
        out.print(file + "::");
        out.print(approved + "::");
       
      }
    } catch (SQLException e) {
      out.println("An error occured while retrieving " + "File information " 
          + e.toString());
    } catch (ClassNotFoundException e) {
      throw (new ServletException(e.toString()));
    } finally {
      try {
        if (stmt != null) {
          stmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException ex) {
      }
    }
    out.println("</center>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}