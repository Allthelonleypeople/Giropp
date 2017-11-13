package net.codejava.upload;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author krish
 */
@WebServlet(urlPatterns = {"/GetData"})
public class GetData extends HttpServlet {

    static Connection con=null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     *
     */
 
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try { this.makeConnection(); //making connection
        PreparedStatement ps = con.prepareStatement("select * from delivery");
        ResultSet rs = ps.executeQuery();
        //make a table here
        out.print("<table border='1'>");
        while(rs.next()){
            //a table row will be created for each record in DB table
            out.print("<tr>");
            //the table data will be inserted into the following table columns <td>
            out.print("<td>"+rs.getInt(1)+"</td>");
            out.print("<td>"+rs.getString(2)+"</td>");
            out.print("<td>"+rs.getBlob(3)+"</td>");
            out.print("</tr>");
        }
         out.print("</table>");
          //end of table
            }
        catch(Exception e){
            System.out.println("Error : " + e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void makeConnection() {
      try{
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/IS_202", "root", "root");
      }
      catch(Exception e){
            System.out.println("Error : " + e);
        }
    
    }
}  