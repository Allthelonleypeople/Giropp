<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css.css">
    </head>

    <body>
        <h1>Viser valgt spørsmål</h1>

        <%
            String driverName = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://localhost:3306/";
            String dbName = "is_202";
            String userId = "StianSim97";
            String password = "Nu3dfMz5s";

            try {
                Class.forName(driverName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
        %>     

        <%
            String id = request.getParameter("id");

            connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM is_202.questions where QuestionID = '" + id + "'";

            resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                out.println("Kunne ikke finne spørsmålet<br><br>");
                out.println("<a href=\"ShowQuestions.jsp\">Prøv igjen</a>");
            } else {
        %>

        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr bgcolor="#848484">
            <meta charset="UTF-8">
            <th>ID</th>
            <th>Navn</th>
            <th>Kategori</th>
            <th>Spørsmål</th>
        </tr>

        <tr bgcolor="#BDBDBD">
            <td> <%= resultSet.getString("QuestionID")%> </td>
            <td> <%= resultSet.getString("navn")%> </td>
            <td> <%= resultSet.getString("kategori")%> </td>
            <td> <%= resultSet.getString("QuestionText")%> </td>
        </tr>
    </table>
    <br>
    <%
        }
    %>

<head>
    <meta charset="UTF-8">
</head>   
<form method="post" action="/EnterpriseApplication1-war/NewCommentServlet">
    <u2>Kommentar:</u2> <br>        
    <textarea name="QuestionComment" rows="10" cols="100"></textarea> <br><br>
    <u2>Navn:</u2> <br>
    <input type="text" name="KommentarNavn" <br> <br> <br>
    <u2>Spørsmåls ID:</u2> <br>
    <input type="text" name="QuestionID" <br> <br> <br>
    <input type="submit" value="Legg igjen kommentar"> <br>
</form>

    <%
        try {
            connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
            statement = connection.createStatement();
            String sql2 = "SELECT * FROM is_202.comments where QuestionID = '" + id + "'";
            
            resultSet = statement.executeQuery(sql2);
            while (resultSet.next()) {           
    %>
    <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr bgcolor="#848484">
        <meta charset="UTF-8">        
        <th>CID</th>
        <th>Navn</th>
        <th>Kommentar</th> 
        <th>QID</th>           
    </tr>

    <tr bgcolor="#BDBDBD"> 
        <td> <%= resultSet.getString("CommentID")%> </td> 
        <td> <%= resultSet.getString("KommentarNavn")%> </td>
        <td> <%= resultSet.getString("QuestionComment")%> </td>
        <td> <%= resultSet.getString("QuestionID")%> </td>
    </tr>
</table>
<%
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
</body>
</html>

