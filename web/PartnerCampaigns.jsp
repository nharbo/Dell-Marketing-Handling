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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link type="text/css" rel="stylesheet" href="HillerStyle.css"/>

        <title>Campaigns</title>
    </head>
    <body>
        <div id="header">
            <h1>Partner campaigns</h1>
            <img src="dell round logo.png" width="150" height="150" alt="dell round logo"/>
        </div>
         <h1><c:out value=""></c:out></h1>
                <table>
                    <thead>
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
                        <td style="border: 1px solid #0066CC">${campaign.campaignId}</td>
                        <td style="border: 1px solid #0066CC">${campaign.startDate}</td>
                        <td style="border: 1px solid #0066CC">${campaign.stopDate}</td>
                        <td style="border: 1px solid #0066CC">${campaign.budget}</td>
                        <td style="border: 1px solid #0066CC">${campaign.status}</td>
                    </tr>

                </c:forEach>
            </table>
        </div>
        <div id="bottom">

        </div>
    </body>
</html>