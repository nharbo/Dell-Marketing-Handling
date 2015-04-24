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

        <title>Partner Dashboard</title>
    </head>
    <body>
        <div id="header">
        <h1> <img src="dell round logo.png" width="150" height="150" alt="dell-logo"/>
            <p><%=session.getAttribute("message")%></p>
        </h1>
        </div>
        
        <%-- "onclick" skal være den side du vil over til når knappen trykkes--%>
        <div id="middle">
            <button class="Button" name="Ansøgning" onclick="location.href = 'campaignRequest.jsp'"/>Request a new campaign</button>

            <form action="Control" method="POST">
                <button class="Button" value="showPartnerCampaigns" name="origin"/>Show all campaigns</button>
            </form>
        </div>
        <div id="bottom">
            
        </div>
    </body>
</html>
