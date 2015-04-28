<%-- 
    Document   : home
    Created on : Mar 23, 2015, 10:05:13 AM
    Author     : nicolaiharbo
--%>

<%@page import="Domain.User"%>
<!DOCTYPE html>
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
        <div id="header">
            <h1> 
                <form action="Control" method="POST">
                    <input type="image" id="myimage" src="dell round logo.png" width="150" height="150" alt="dell-logo" name="origin" value="homebutton"/>
                </form>
                <p><%=session.getAttribute("message")%></p>
            </h1>
        </div>

        <div class="container">

            <div class="masthead">
                <h3 class="text-muted">Dell</h3>
                <nav>
                    <form action="Control" method="POST">
                        <ul class="nav nav-justified">
                            <li><a href="awaitingRequests.jsp" value="awaitingRequests" name="origin">Awaiting requets</a></button></li>
                            <li><button class="Button" value="showActiveCampaigns" name="origin"/>Active campaigns</button></li>
                            <li><button class="Button" value="showInactiveCampaigns" name="origin"/>Inactive campaigns</button></li>
                            <li> <button class="Button" value="showPartners" name="origin">Edit/Delete partner</button></li>
                        </ul>
                    </form>
                </nav>
            </div>
        </div>

        <%-- "onclick" skal være den side du vil over til når knappen trykkes--%>
        <div id="middle">
            <form action="Control" method="POST">
                <button class="Button" value="awaitingRequests" name="origin">Awaiting requests</button>

                <button class="Button" value="showActiveCampaigns" name="origin"/>Active campaigns</button>

                <button class="Button" value="showInactiveCampaigns" name="origin"/>Inactive campaigns</button>

                <button class="Button" value="showPartners" name="origin">Edit/Delete partner</button>
            </form>

            <button class="Button" name="Ny" onclick="location.href = 'registration.jsp'" />Add new partner</button>

        <form action="Control" method="POST">
            <button class="Button" value="logout" name="origin">Logout!</button>
        </form>
    </div>

    <%----%>
    <div id="bottom">

    </div>

</body>
</html>
