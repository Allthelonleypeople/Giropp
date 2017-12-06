<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<html>
    <head>
        <title>Finn QuestionID</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css.css">
    </head>

    <body>
        <div class  ="row">
            <div class ="column venstreheader">
                <a href="Hovedmeny.html"> <img src="C:\Users\Stian\Desktop\Notater\IS-202\SLit-Utvikling\SLITSYSTEM\SLITSYSTEM-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
                </a>
            </div>    
            <div class ="column header left">
                <h2>Valgt spørsmål</h2>
            </div>
            <div class ="column header right"> 
                <h2>Bruker</h2>
            </div>
        </div>

        <div class ="venstre">
        </div>

        <div class="midt">     

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
                    out.println("<a href=\"VisSporsmal.jsp\">Prøv igjen</a>");
                } else {
            %>

            <table align="left" cellpadding="5" cellspacing="5" border="1" bgcolor="#c40c32">
                <tr bgcolor="#ffffff">
                <meta charset="UTF-8">
                <th>ID</th>
                <th>Navn</th>
                <th>Kategori</th>
                <th>Spørsmål</th>
                </tr>

                <tr bgcolor="ffffff">
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
            <br><br><br><br>
            <head>
                <meta charset="UTF-8">
            </head>
            <form method="post" action="/SLITSYSTEM-war/NewCommentServlet">
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
            <table align="left" cellpadding="5" cellspacing="5" border="1" bgcolor="#c40c32">
                <tr bgcolor="#ffffff">
                <meta charset="UTF-8">        
                <!--<th>KommentarID</th>-->
                <th>Navn</th>
                <th>Kommentar</th> 
                <th>SpørsmålsID</th>           
                </tr>
                <br>

                <tr bgcolor="#ffffff"> 
                   <!-- <td> <%= resultSet.getString("CommentID")%> </td> -->
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
        </div>
    </body>
</html>

