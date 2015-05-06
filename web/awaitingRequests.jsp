<%-- 
    Document   : activeCampaigns
    Created on : Apr 9, 2015, 12:35:32 PM
    Author     : nicolaiharbo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List, java.util.ArrayList, java.util.Iterator, java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Awaiting campaign requests</title>
    </head>
    <body> 
        <div class="container">

            <div class="masthead">
                <h3 class="text-muted">Dell marketing</h3>
                <nav>
                    <form action="Control" method="POST">
                        <ul class="nav nav-justified">
                            <li><a href="Control?origin=homebutton">Home</a></li>
                            <li><a href="Control?origin=awaitingRequests">Awaiting requests</a></li>
                            <li><a href="Control?origin=showActiveCampaigns"/>Active campaigns</a></li>
                            <li><a href="Control?origin=showInactiveCampaigns"/>Inactive campaigns</a></li>
                            <li><a href="registration.jsp">Create partner</a></li>
                            <li><a href="Control?origin=showPartners">Partner list</a></li>
                            <li><a href="Control?origin=logout"/>Logout</a></li>
                        </ul>
                    </form>
                </nav>
            </div>

            <!-- Jumbotron -->
            <div class="jumbotron">
                <p class="lead">    
                </p>
            </div>
            <h1><c:out value="Awaiting requests"></c:out></h1>
                <table>
                    <thead>
                    <th>
                        Partner
                    </th>
                    <th>
                        Campaign id
                    </th>
                    <th>
                        Partner id
                    </th>
                    <th>
                        Startdate
                    </th>
                    <th>
                        Stopdate
                    </th>
                    <th>
                        Campaignbudget
                    </th>
                    <th>
                        Country
                    </th>
                    <th>
                        Status
                    </th>
                    </thead>

                <c:forEach var="campaign" items="${campaignReqList}">
                    <tr>
                        <td style="border: 1px solid #0066CC">${campaign.user}</td>
                        <td style="border: 1px solid #0066CC">${campaign.campaignId}</td>
                        <td style="border: 1px solid #0066CC">${campaign.partnerId}</td>
                        <td style="border: 1px solid #0066CC">${campaign.startDate}</td>
                        <td style="border: 1px solid #0066CC">${campaign.stopDate}</td>
                        <td style="border: 1px solid #0066CC">${campaign.budget}</td>
                        <td style="border: 1px solid #0066CC">${campaign.country}</td>
                        <td style="border: 1px solid #0066CC">${campaign.status}</td>
                    </tr>

                </c:forEach>
            </table>

            <form action="Control" method="POST">
                Campaign id: 
                <select name="Campaignid" required>
                    <c:forEach var="campaign" items="${campaignReqList}">

                        <option>${campaign.campaignId}</option>

                    </c:forEach>
                </select> 
                <button class="btn btn-primary" name="origin" value="disapproveCampaignRequest">Disapprove campaign!</button>
                <button class="btn btn-primary" name="origin" value="acceptCampaignRequest">Accept campaign!</button>
            </form>
            <!-- Site footer -->
            <footer class="footer">
                <p>&copy; Dell 2015</p>
            </footer>

        </div>
    </body>
</html>
