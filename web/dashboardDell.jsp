<%-- 
    Document   : home
    Created on : Mar 23, 2015, 10:05:13 AM
    Author     : nicolaiharbo
--%>

<%@page import="Domain.User"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap core CSS -->
        <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

        <%-- Link til CSS style filen. --%>
        <link type="text/css" rel="stylesheet" href="StyleDashboard.css"/>
        <title>Dell Dashboard</title>
    </head>
    <body>
        <div class="container">
            <div class="masthead">
                <h3 class="text-muted">Dell marketing</h3>
                <nav>
                        <ul class="nav nav-justified">
                            <li><a href="Control?origin=awaitingRequests">Awaiting requests</a></li>
                            <li><a href="Control?origin=showActiveCampaigns"/>Active campaigns</a></li>
                            <li><a href="Control?origin=showInactiveCampaigns"/>Inactive campaigns</a></li>
                            <li><a href="Control?origin=showPartners">Edit/Delete partner</a></li>
                            <li><a href="Control?origin=logout"/>Logout</a></li>
                        </ul>
                </nav>
            </div>
            <!-- Jumbotron -->
            <div class="jumbotron">
                <h2><%=session.getAttribute("message")%></h2>
                <p class="lead"></p>
            </div>
        </div>
        <%----%>
        <div id="bottom">

        </div>

    </body>
</html>
