<%-- 
    Document   : PartnerCampaigns
    Created on : 20-04-2015, 12:31:02
    Author     : Daniel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, java.util.ArrayList, java.util.Iterator, java.util.Enumeration"%>
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

        <title>Partner campaigns</title>
    </head>
    <body>
        <div class="container">

            <div class="masthead">
                <h3 class="text-muted">Dell marketing</h3>
                <nav>
                    <ul class="nav nav-justified">
                        <li><a href="Control?origin=homebuttonPartner">Home</a></li>
                        <li><a href="Control?origin=showCampaignReqSite">Request a new campaign</a></li>
                        <li><a href="Control?origin=showPartnerCampaigns"/>Show your campaigns</a></li>
                        <li><a href="Control?origin=logout"/>Logout</a></li>
                    </ul>
                </nav>
            </div>

            <!-- Jumbotron -->
            <div class="jumbotron">
                <p class="lead">    
                </p>
            </div>
            <h1>Campaigns</h1>
            <h1><c:out value=""></c:out></h1>
                <table>
                    <thead>
                    <th>
                        Partner
                    </th>
                    <th>
                        Campaign id
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
                        Status
                    </th>
                    </thead>
                    
                <c:forEach var="campaign" items="${partnercampaigns}">
                    <tr>
                        <td style="border: 1px solid #0066CC">${campaign.user}</td>
                        <td style="border: 1px solid #0066CC">${campaign.campaignId}</td>
                        <td style="border: 1px solid #0066CC">${campaign.startDate}</td>
                        <td style="border: 1px solid #0066CC">${campaign.stopDate}</td>
                        <td style="border: 1px solid #0066CC">${campaign.budget}</td>
                        <td style="border: 1px solid #0066CC">${campaign.status}</td>
                    </tr>
                </c:forEach>
            </table>

            <form action="Control" method="POST">
                Campaign ID:    
                <select name="campaignid" required>
                    <c:forEach var="campaign" items="${partnercampaigns}">

                        <option>${campaign.campaignId}</option>

                    </c:forEach>
                </select>

                <button class="btn btn-primary" value="sendPOEPage" name="origin">Upload POE</button>

            </form>
            <!-- Site footer -->
            <footer class="footer">
                <p>&copy; Dell 2015</p>
            </footer>
        </div>
    </body>
</html>