<%-- 
    Document   : home
    Created on : Mar 23, 2015, 10:05:13 AM
    Author     : nicolaiharbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="stylesheet" href="DashBoardStyle.css" type="text/css">
      
       
        <title>JSP Page</title>
    </head>
    <body>
        <h1> <img src="dell round logo.png" width="150" height="150" alt="dell-logo"/>
            <p><%=session.getAttribute("message")%></p>
        </h1>
       
        <%-- "onclick" skal være den side du vil over til når knappen trykkes--%>
        <div>
        <input class="Button" type="submit" value="Anmodninger" name="Anmodninger" onclick="location.href='NæsteSide'"/>
    
        <input class="Button" type="submit" value="Igangværende kampagner" name="IK" onclick="location.href='activeCampaigns.jsp'" />
       
        <input class="Button" type="submit" value="Tilføj ny partner" name="Ny" onclick="location.href='registration.jsp'" />
             
        <input class="Button" type="submit" value="Rediger/Slet partner" name="RDP" onclick="location.href='NæsteSide'" />
        </div>
      
        <%----%>
        
        
    </body>
</html>
