<%-- 
    Document   : showPOE
    Created on : Apr 22, 2015, 10:11:47 AM
    Author     : nicolaiharbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                        <li><a href="Control?origin=homebutton">Home</a></li>
                        <li><a href="Control?origin=awaitingRequests">Awaiting requests</a></li>
                        <li><a href="Control?origin=showActiveCampaigns"/>Active campaigns</a></li>
                        <li><a href="Control?origin=showInactiveCampaigns"/>Inactive campaigns</a></li>
                        <li><a href="registration.jsp">Create partner</a></li>
                        <li><a href="Control?origin=showPartners">Partner list</a></li>
                        <li><a href="Control?origin=logout"/>Logout</a></li>
                    </ul>
                </nav>
            </div>
            <h1>
                <%=session.getAttribute("message")%>
            </h1>

            <img src="ImgServlet?campaignid=${campaignid}"/>

            <form action="Control" method="POST">

                <button class="btn btn-primary" value="approvePOE" name="origin">Approve POE</button>
                <button class="btn btn-primary" value="disapprovePOE" name="origin">Disapprove POE</button>
            </form>
            <footer class="footer">
                <p>&copy; Dell 2015</p>
            </footer>
        </div>
    </body>
</html>
