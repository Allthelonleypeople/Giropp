package Forum;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Management.QuestionManagerLocal;

@WebServlet("NewQuestionServlet")
public class NewQuestionServlet extends HttpServlet {

    @EJB
    QuestionManagerLocal manager;

    private void newQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String navn = request.getParameter("navn");
        String kategori = request.getParameter("kategori");
        String QuestionText = request.getParameter("QuestionText");

        Questions q = new Questions(navn, kategori, QuestionText);
        if (manager.saveQuestion(q) == true) {
            out.print("Ditt spørsmål har nå blitt lagret!");
            out.print("Du vil nå bli videresendt til forum-siden");
            response.sendRedirect("/SLITSYSTEM-war/Forum");
        } else if (manager.saveQuestion(q) == false) {
            out.print("Spørsmålet ble ikke lagret, prøv igjen..");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newQuestion(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newQuestion(request, response);
    }
}
