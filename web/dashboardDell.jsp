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
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%-- Link til CSS style filen. --%>
        <link type="text/css" rel="stylesheet" href="HillerStyle.css"/>

        <title>Dell Dashboard</title>
    </head>
    <body>
        <div id="header">
        <h1> <img src="dell round logo.png" width="150" height="150" alt="dell-logo"/>
            <p><%=session.getAttribute("message")%></p>
        </h1>
        </div>

        <%-- "onclick" skal være den side du vil over til når knappen trykkes--%>
        <div id="middle">
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
        <div id="bottom">
            
        </div>

    </body>
</html>
