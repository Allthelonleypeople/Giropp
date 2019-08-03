package Teacher;

import Management.UserManagerLocal;
        import users.Teacher;
        import javax.ejb.EJB;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;


@WebServlet ("/NewTeacherServlet")


public class NewTeacherServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    private void newTeacher (HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("passWord");
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        

        Teacher t = new Teacher(email.toLowerCase(), password, fName, lName);
        if(manager.saveUser(t) == true){
            out.print("Din bruker har blitt opprettet!  ");
            out.print("Du vil nå bli videresendt til innloggingen   ");
            response.sendRedirect("/EnterpriseApplication1-war/index.html");
        } else if (manager.saveUser(t) == false){
            out.print("Din bruker kunne ikke bli opprettet, vennligst prøv igjen ");
        }
        
      

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newTeacher(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newTeacher(request, response);
    }
}

