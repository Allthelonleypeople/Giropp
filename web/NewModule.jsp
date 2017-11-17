<%-- 
    Document   : NewModule
    Created on : 16.nov.2017, 12:44:46
    Author     : sindrethompson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <form method="post" action="/Slitsystem/OppgaveServlet"> 
            <br>
            Oppgave    :<input type="text" name="task" /><br/><br/>
            Criterias   :<input type="text" name="criterias" /><br/><br/>
            Dato :<input type ="text" name="deadline" /><br/><br/>
            <input type="submit" value="Registrer" /><br><br/>
        
    </body>
</html>
