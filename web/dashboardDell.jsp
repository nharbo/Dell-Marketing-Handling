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
        <link type="text/css" rel="stylesheet" href="cssStyle.css"/>

        <title>Dell Dashboard</title>
    </head>
    <body>
        <div id="header">
            <h1> 
                <form action="Control" method="POST">
                    <input type="image" id="myimage" src="dell round logo.png" width="150" height="150" alt="dell-logo" name="origin" value="homebutton"/>
                </form>
                <p><%=session.getAttribute("message")%></p>
            </h1>
        </div>

        <%-- "onclick" skal være den side du vil over til når knappen trykkes--%>
        <div id="middle">
            <form action="Control" method="POST">
                <button class="Button" value="awaitingRequests" name="origin">Awaiting requests</button>
            </form>

            <form action="Control" method="POST">
                <button class="Button" value="showActiveCampaigns" name="origin"/>Active campaigns</button>
            </form>

            <form action="Control" method="POST">
                <button class="Button" value="showInactiveCampaigns" name="origin"/>Inactive campaigns</button>
            </form>

            <button class="Button" name="Ny" onclick="location.href = 'registration.jsp'" />Add new partner</button>

        <form action="Control" metohd="POST">
            <button class="Button" value="showPartners" name="origin"/>Edit/Delete partner</button>
        </form>
    </div>

    <%----%>
    <div id="bottom">

    </div>

</body>
</html>
