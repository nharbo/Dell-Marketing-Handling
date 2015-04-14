<%-- 
    Document   : activeCampaigns
    Created on : Apr 9, 2015, 12:35:32 PM
    Author     : nicolaiharbo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, java.util.ArrayList, java.util.Iterator, java.util.Enumeration"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Active campaigns</title>
    </head>
    <body>
        <div id="container">

    </body>
    <body> 
     

        <h1><c:out value="Campaign"></c:out></h1>
        
            <table style="border: 1px solid #0066cc">

                <thead>
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
                    Status
                </th>
            </thead>



        <c:forEach var="campaign" items="${campaignList}">
            <tr>
                <td style="border: 1px solid #0066CC">${campaign.campaignId}</td>
                <td style="border: 1px solid #0066CC">${campaign.partnerId}</td>
                <td style="border: 1px solid #0066CC">${campaign.startDate}</td>
                <td style="border: 1px solid #0066CC">${campaign.stopDate}</td>
                <td style="border: 1px solid #0066CC">${campaign.budget}</td>
                <td style="border: 1px solid #0066CC">${campaign.status}</td>
            </tr>

        </c:forEach>
    </table>

</body>
</html>
