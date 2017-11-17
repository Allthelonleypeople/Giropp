<%-- 
    Document   : Login
    Created on : 16.nov.2017, 12:23:13
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
        
<h1>Velkommen til Slit, vennligst logg inn</h1>
<form action="/Slitsystem/Login" method="post">
    Email: <input name="email" type="text"><br>

    Passord: <input name="passWord" type="password"><br>


    <input type="submit" value="Logg inn"> <br> <br>

    <a href="NewStudent.jsp">Ny bruker? Registrer deg her</a>

    </body>
</html>
