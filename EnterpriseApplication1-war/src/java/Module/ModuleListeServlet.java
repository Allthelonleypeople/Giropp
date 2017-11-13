/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import javax.ejb.EJB;
import Management.ModuleManagerLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sindrethompson
 */
@WebServlet(name = "ModuleListeServlet", urlPatterns = {"/ModuleListeServlet"})
public class ModuleListeServlet extends HttpServlet {

@EJB
ModuleManagerLocal em;

private void listModule(HttpServletRequest req, HttpServletResponse res) throws IOException {
    boolean lel = true;
    
    if (lel = true) {
        //PrintWriter out = res.getWriter();
        ModuleOppgave modul = em.getModuleOppgave(1);
        String navn = modul.getNavn();
        String fag = modul.getFag();
        String publisertAv = modul.getPublisertAv();
        String deadline = modul.getDeadline();
        
        req.getSession().setAttribute("navn", navn);
        res.sendRedirect("VisModul.html");
        
   // } else if (req.getParameter("module2") != null) {
     //   ModuleOppgave modul = em.getModuleOppgave(2);
       // String navn = modul.getNavn();
        //String fag = modul.getFag();
        //String publisertAv = modul.getPublisertAv();
        //String deadline = modul.getDeadline();
        
       // res.sendRedirect("VisModul.html");
        
        
        
    }
}


@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
    listModule(req, res);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
    listModule(req, res);


}
}