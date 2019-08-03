<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

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
<h2 align="center"><font><strong>Viser spørsmålene relatert til Modul 1</strong></font></h2>
<meta charset="UTF-8">
<table align="center" cellpadding="5" cellspacing="5" border="1">
    <link rel="stylesheet" href="css.css">    
    <tr>

    </tr>
    <tr bgcolor="#848484">
        <td><b>Navn</b></td>
        <td><b>Kategori</b></td>
        <td><b>Spørsmål</b></td>
    </tr>
    <%
        try {
            connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM is_202.questions where kategori = 'Modul 1'";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
    %>
    <tr bgcolor="#BDBDBD">

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
