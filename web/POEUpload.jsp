<%-- 
    Document   : POEUpload
    Created on : 20-04-2015, 12:37:47
    Author     : Florent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link type="text/css" rel="stylesheet" href="DashBoardStyle.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Control" method="POST" enctype="multipart/form-data" name="Poeup">
            <%-- Campaign ID skal helst selv fyldes ud når du kommer ind på denne side, indtil videre skal det gøres manuelt --%>
            POEID: <input type="text" name="POEID">
            CampaignID: <input type="text" name="CampaignID">
            
            Attach POE FILE: <input type="file" name="POEFile">
            <input type="submit" value="Send">
            <input type="hidden" name="origin" value="POEUpload">
        
        </form>
    </body>
</html>
