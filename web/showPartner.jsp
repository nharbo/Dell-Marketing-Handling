

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
        <title>Partners</title>
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

            <h1><c:out value="Partner"></c:out></h1>

                <table>

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
                <button class="btn btn-primary" value="deletePartner" name="origin">Delete partner</button>
                <button class="btn btn-primary" value="editPartnerPage" name="origin">Edit partner</button>
            </form>

            <!-- Site footer -->
            <footer class="footer">
                <p>&copy; Dell 2015</p>
            </footer>
        </div>
    </body>
</html>
