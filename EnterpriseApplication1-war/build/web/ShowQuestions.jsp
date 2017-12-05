<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<div class ="row">
    <div class ="column venstreheader">
        <img src="C:\Users\Stian\Desktop\Notater\IS-202\Giropp-Development\EnterpriseApplication1-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
    </div>
    <div class ="column header left"><h2>Spørsmål</h2></div>
    <div class ="column header right"><h2>Bruker</h2></div>
</div>       
<div class="venstre"></div>  
<div class="midt">
    <%
        String id = request.getParameter("userId");
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
    <meta charset="UTF-8">
    <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr>

        </tr>
        <meta charset="UTF-8">
        <tr bgcolor="#848484">
            <td><b>ID</b></td>    
            <td><b>Navn</b></td>
            <td><b>Kategori</b></td>
            <td><b>Spørsmål</b></td>
        </tr>
        <%
            try {
                connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
                statement = connection.createStatement();
                String sql = "SELECT * FROM is_202.questions order by kategori, QuestionID";

                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
        %>
        <tr bgcolor="#BDBDBD">

            <td><%=resultSet.getString("QuestionID")%></td>
            <td><%=resultSet.getString("navn")%></td>
            <td><%=resultSet.getString("kategori")%></td>
            <td><%=resultSet.getString("QuestionText")%></td>

        </tr>

        <%
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>

    <html> 
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <body>        

            <form method="post" action="FinnQID.jsp"> <!-- style="height: 100px; width: 300px;"> -->
                <h5 center>Skriv inn "ID" for å få opp kommentarer</h5>
                <input type="text" name="id"> <br> <br>
                <input type="submit" value="Vis"> <br>
            </form>
            <a href="/EnterpriseApplication1-war/Forum">Tilbake</a>

</div>
</body>
</html>