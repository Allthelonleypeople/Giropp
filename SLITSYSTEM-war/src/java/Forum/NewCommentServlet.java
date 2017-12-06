package Forum;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Management.CommentManagerLocal;

@WebServlet("NewCommentServlet")
public class NewCommentServlet extends HttpServlet {

    @EJB
    CommentManagerLocal manager;

    private void newComment(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String QuestionComment = request.getParameter("QuestionComment");
        String KommentarNavn = request.getParameter("KommentarNavn");
        String QuestionID = request.getParameter("QuestionID");
        
        Comments c = new Comments(QuestionComment, KommentarNavn, QuestionID);
        if (manager.saveComment(c) == true) {
            out.print("Din kommentar har blir lagret!");
            out.print("Du vil nå bli sendt tilbake spørsmålssiden");
            response.sendRedirect("VisSporsmal.jsp");
        } else if (manager.saveComment(c) == false) {
            out.print("Kommentaren ble ikke lagret, prøv igjen..");
        }

    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        newComment(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newComment(request, response);
    }
}
