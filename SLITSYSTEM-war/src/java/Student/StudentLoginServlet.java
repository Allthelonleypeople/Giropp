package Student;

import Management.UserManagerLocal;
import users.Bruker;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sindre
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Bruker u = manager.getUser(email.toLowerCase());
        if (u.getPassword().equals(password) && (u.getEmail().equals(email))) {
            response.sendRedirect("Hovedmeny.html");

        } else {            
            response.sendRedirect("Feilmelding.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        login(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        login(request, response);
    }
}
