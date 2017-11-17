<%-- 
    Document   : NewStudent
    Created on : 16.nov.2017, 12:14:24
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
        <h1>Hello World!</h1>
        <form action="NewStudentServlet">
                 <br>
        Email     :<input type="text" name="email" /><br/><br/>
        Passord   :<input type="password" name="passWord" /><br/><br/>
        Fornavn   :<input type ="text" name="firstName" /> <br/><br/>
        Etternavn :<input type ="text" name="lastName" /> <br/><br/>
        <input type="submit" value="Registrer"/>
        </form>
    </body>
</html>
