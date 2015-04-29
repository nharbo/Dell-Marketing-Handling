<%-- 
    Document   : showPartner
    Created on : 14-04-2015, 09:12:49
    Author     : Florent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link type="text/css" rel="stylesheet" href="StyleGeneral.css"/>
        <title>Partners</title>
    </head>
    <body>
        <div class="container">

            <div class="masthead">
                <h3 class="text-muted"><%=session.getAttribute("message")%></h3>
                <nav>
                    <form action="Control" method="POST">
                        <ul class="nav nav-justified">
                            <li><a href="awaitingRequests.jsp" value="awaitingRequests" name="origin">Awaiting requets</a></button></li>
                            <li><a href="activeCampaigns.jsp" value="showActiveCampaigns" name="origin"/>Active campaigns</a></button></li>
                            <li><a href="disapprovedCampaigns.jsp" value="showInactiveCampaigns" name="origin"/>Inactive campaigns</a></button></li>
                            <li><a href="showPartner.jsp" value="showPartners" name="origin">Edit/Delete partner</a></button></li>
                        </ul>
                    </form>
                </nav>
                <img src="banner-dell.jpg" alt="banner-dell"/>
            </div>


            <!-- Jumbotron -->
            <div class="jumbotron">

            </div>
        </div>
        <div id="header">

            <form action="Control" method="POST">
                <input type="image" id="myimage" src="dell round logo.png" width="150" height="150" alt="dell-logo" name="origin" value="homebutton"/>
            </form>

        </div>
        <div id="middle">
            <h1><c:out value="Partner"></c:out></h1>

                <table style="border: 1px solid #0066cc">

                    <thead>
                    <th>
                        User id
                    </th>
                    <th>
                        Partner id
                    </th>
                    <th>
                        Partner name
                    </th>
                    <th>
                        Address
                    </th>
                    <th>
                        CVR-number
                    </th>
                    <th>
                        Phone
                    </th>
                    <th>
                        Zip
                    </th>
                    </thead>



                <c:forEach var="partners" items="${partnerList}">
                    <tr>
                        <td style="border: 1px solid #0066CC">${partners.userid}</td>
                        <td style="border: 1px solid #0066CC">${partners.partnerid}</td>
                        <td style="border: 1px solid #0066CC">${partners.partnername}</td>
                        <td style="border: 1px solid #0066CC">${partners.address}</td>
                        <td style="border: 1px solid #0066CC">${partners.cvr}</td>
                        <td style="border: 1px solid #0066CC">${partners.phone}</td>
                        <td style="border: 1px solid #0066CC">${partners.zip}</td>
                    </tr>

                </c:forEach>
            </table>
            <form action="Control" method="POST">
                <select name="userid">
                    <c:forEach var="partners" items="${partnerList}">

                        <option>${partners.userid}</option>

                    </c:forEach>
                </select> 
                <button value="deletePartner" name="origin">Delete partner</button>
                <button value="editPartnerPage" name="origin">Edit partner</button>
            </form>

            <div id="bottom">

            </div>
    </body>
</html>
