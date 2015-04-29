<%-- 
    Document   : disapprovedCampaigns
    Created on : Apr 21, 2015, 10:10:32 AM
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
        <title>Disapproved campaigns</title>
    </head>
    <body> 
        <div class="container">

            <div class="masthead">
                <h3 class="text-muted">Dell marketing</h3>
                <nav>
                    <form action="Control" method="POST">
                        <ul class="nav nav-justified">
                            <li><a href="awaitingRequests.jsp" value="awaitingRequests" name="origin">Awaiting requests</a></button></li>
                            <li><a href="activeCampaigns.jsp" value="showActiveCampaigns" name="origin"/>Active campaigns</a></button></li>
                            <li><a href="disapprovedCampaigns.jsp" value="showInactiveCampaigns" name="origin"/>Inactive campaigns</a></button></li>
                            <li><a href="showPartner.jsp" value="showPartners" name="origin">Edit/Delete partner</a></button></li>
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
            <h1><c:out value="Disaproved Campaigns"></c:out></h1>
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


                <c:forEach var="campaign" items="${disCampaignList}">
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
                <button class="btn btn-primary" type="submit" value="clearDisapproved" name="origin">Clear list</button>
            </form>

            <!-- Site footer -->
            <footer class="footer">
                <p>&copy; Dell 2015</p>
            </footer>
        </div>
    </body>
</html>
