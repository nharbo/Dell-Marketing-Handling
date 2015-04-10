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
        <a href="Control?origin=showActiveCampaigns">Klik her tak</a>
        <h1>Heres a list of active campaigns
        </h1>
        <h1><c:out value="Campaigns"></c:out></h1>
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



        <c:forEach var="Campaigns" items="${campaignList}">
            <tr>
                <td style="border: 1px solid #0066CC">${Campaigns.c_id}</td>
                <td style="border: 1px solid #0066CC">${Campaigns.c_id}</td>
                <td style="border: 1px solid #0066CC">${Campaigns.c_id}</td>
                <td style="border: 1px solid #0066CC">${Campaigns.c_id}</td>
                <td style="border: 1px solid #0066CC">${Campaigns.c_id}</td>
                <td style="border: 1px solid #0066CC">${Campaigns.c_id}</td>
            </tr>

        </c:forEach>
    </table>

</body>
</html>
