<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class ="row">
            <div class ="column venstreheader">
                <img src="C:\Users\Stian\Desktop\Notater\IS-202\Giropp-Development\EnterpriseApplication1-war\resources\UiA_logo1.jpg" alt="Uia logo" width="60" height="60">
            </div>
            <div class ="column header left"><h2>Moduler</h2></div>
            <div class ="column header right"><h2>Lærer</h2></div>
        </div>       
        <div class="venstre"></div>  

        <form method="post" action="/Slitsystem/OppgaveServlet"> 
            <br>                
            <div class="midt">
                Oppgave : <br>
                <input type="text" name="task"> <br><br>

                Kriterier : <br>
                <input type="text" nam="criterias"> <br><br>

                Deadline : <br>
                <input type ="text" name="deadline"> <br>
                <input type="submit" value="Registrer">
            </div>
        </form>
    </body>
</html>