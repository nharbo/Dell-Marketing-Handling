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
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%-- Link til CSS style filen. --%>
        <link type="text/css" rel="stylesheet" href="cssStyle.css"/>

        <title>Campaigns</title>
    </head>
    <body>
        <div id="header">
            <h1>Partner campaigns</h1>
            <form action="Control" method="POST">
                <input type="image" id="myimage" src="dell round logo.png" width="150" height="150" alt="dell-logo" name="origin" value="homebutton"/>
            </form>
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

    <form action="Control" method="POST">

        <select name="campaignid">
            <c:forEach var="campaign" items="${campaignList}">

                <option>${campaign.campaignId}</option>

            </c:forEach>
        </select>
        Campaign ID: 
        <button value="origin" name="sendPOEPage">Upload POE</button>

    </form>
</div>
<div id="bottom">

</div>
</body>
</html>