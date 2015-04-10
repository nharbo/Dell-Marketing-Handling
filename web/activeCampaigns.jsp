<%-- 
    Document   : activeCampaigns
    Created on : Apr 9, 2015, 12:35:32 PM
    Author     : nicolaiharbo
--%>

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
        <a href='Control?origin=showActiveCampaigns'>Show active campaign</a>
   </body>
   <body> 
        <h1>Heres a list of active campaigns</h1>
        <table>
            <c:forEach var="Campaign" items="${requestScope.campaign}">
               
                </c:choose>
                
                <td><c:out value="${campaign.campaignId}"/></td>
                <td><c:out value="${campaign.startDate}"/></td>
                <td><c:out value="${campaign.stopDate}"/></td>
                <td><c:out value="${campaign.budget}"/></td>
                <td><c:out value="${campaign.status}"/></td>
                </tr>
            </c:forEach>
        </table></div>
</div id="container">

</body>
</html>
