<%-- 
    Document   : disapprovedCampaigns
    Created on : Apr 21, 2015, 10:10:32 AM
    Author     : nicolaiharbo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, java.util.ArrayList, java.util.Iterator, java.util.Enumeration"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link type="text/css" rel="stylesheet" href="HillerStyle.css"/>
        <title>Disapproved campaigns</title>
    </head>
    <body> 
        <div id="header">
            <h1>Disapproved campaigns</h1>
            <img src="dell round logo.png" width="150" height="150" alt="dell round logo"/>          
        </div>
        <div id="middle">
            <h1><c:out value=""></c:out></h1>
                <table>
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
                        Country
                    </th>
                    <th>
                        Status
                    </th>
                    </thead>


                <c:forEach var="campaign" items="${disCampaignList}">
                    <tr>
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
        </div>
        <form action="Control" method="POST">
            <table border="0">
                <tbody>
                    <tr>    
                        <th><input class="DButton" type="submit" value="Clear list" name="clearDis"></th>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="origin" value="clearDisapproved">
        </form>
        <div id="bottom">

        </div>
    </body>
</html>