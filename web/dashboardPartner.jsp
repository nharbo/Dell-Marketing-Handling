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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap core CSS -->
        <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

        <%-- Link til CSS style filen. --%>
        <link type="text/css" rel="stylesheet" href="StyleDashboard.css"/>

        <title>Partner Dashboard</title>
    </head>
    <body>
        <div id="header">
            <h1>                 
                <form action="Control" method="POST">
                    <input type="image" id="myimage" src="dell round logo.png" width="150" height="150" alt="dell-logo" name="origin" value="homebuttonPartner"/>
                </form>
                <p><%=session.getAttribute("message")%></p>
            </h1>
        </div>

        <%-- "onclick" skal være den side du vil over til når knappen trykkes--%>
        <div id="middle">
            <form action="Control" method="POST">
                <button class="Button" value="showCampaignReqSite" name="origin"/>Request a new campaign</button>
            </form>

            <form action="Control" method="POST">
                <button class="Button" value="showPartnerCampaigns" name="origin"/>Show all campaigns</button>
            </form>

            <form action="Control" method="POST">
                <button class="Button" value="logout" name="origin">Logout!</button>
            </form>
        </div>
        <div id="bottom">

        </div>
    </body>
</html>
