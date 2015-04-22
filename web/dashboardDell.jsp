<%-- 
    Document   : home
    Created on : Mar 23, 2015, 10:05:13 AM
    Author     : nicolaiharbo
--%>

<%@page import="Domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="DashBoardStyle.css" type="text/css">

        <title>Dell Dashboard</title>
    </head>
    <body>
        <h1> <img src="dell round logo.png" width="150" height="150" alt="dell-logo"/>
            <p><%=session.getAttribute("message")%></p>
        </h1>

        <%-- "onclick" skal være den side du vil over til når knappen trykkes--%>
        <div>
            <form action="Control" method="POST">
                <input class="Button" type="submit" value="Awaiting requests" name="Anmodninger"/>
                <input type="hidden" name="origin" value="awaitingRequests">
            </form>

            <form action="Control" method="POST">
                <input class="Button" type="submit" value="Active campaigns" name="AC"/>
                <input type="hidden" name="origin" value="showActiveCampaigns">
            </form>

            <form action="Control" method="POST">
                <input class="Button" type="submit" value="Inactive campaigns" name="IC"/>
                <input type="hidden" name="origin" value="showInactiveCampaigns">
            </form>

            <input class="Button" type="submit" value="Add new partner" name="Ny" onclick="location.href = 'registration.jsp'" />

            <form action="Control" metohd="POST">
                <input class="Button" type="submit" value="Edit/Delete partner" name="RDP"/>
                <input type="hidden" name="origin" value="showPartners">
            </form>
        </div>

        <%----%>


    </body>
</html>
