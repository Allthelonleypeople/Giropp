
package Forum;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sindre
 */
@WebServlet(name = "Forum", urlPatterns = {"/Forum"})
public class Forum extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Forum meny</title>");
            out.println("<link rel=\"stylesheet\" href=\"css.css\">");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class =\"row\">");
            out.println("<div class =\"column venstreheader\"> "
                    + "<a href=\"Hovedmeny.html\"> <img src=\"C:\\Users\\Stian\\Desktop\\Notater\\IS-202\\SLit-Utvikling\\SLITSYSTEM\\SLITSYSTEM-war\\resources\\UiA_logo1.jpg\" "
                    + "alt=\"Uia logo\" width=\"60\" height=\"60\"> </a> </div>");
            out.println("<div class =\"column header left\"> <h2>Forum meny</h2> </div>");
            out.println("<div class =\"column header right\"> <h2>Bruker</h2> </div>");
            out.println("</div>");
            out.println("<div class =\"venstre\"> </div>");
            out.println("<div class=\"midt\">");
            out.println("<form action=\"FAQ.html\"><button class=\"button\"><span>FAQ </span></button></form>");
            out.println("<form action=\"SporsmalKategori.html\"><button class=\"button\"><span>Kategorier </span></button></form>");
            out.println("<form action=\"NyttSporsmal.html\"><button class=\"button\"><span>Nytt spørsmål </span></button></form>");
            out.println("<form action=\"VisSporsmal.jsp\"><button class=\"button\"><span>Se spørsmål </span></button></form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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

}
