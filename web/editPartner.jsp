<%-- 
    Document   : registration
    Created on : Mar 23, 2015, 10:04:44 AM
    Author     : nicolaiharbo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <title>Partner edit</title>
    </head>
    <body>
        <div class="container">

            <div class="masthead">
                <h3 class="text-muted">Dell marketing</h3>
                <nav>
                    <form action="Control" method="POST">
                        <ul class="nav nav-justified">
                            <li><a href="Control?origin=homebutton">Home</a></li>
                            <li><a href="Control?origin=awaitingRequests">Awaiting requests</a></li>
                            <li><a href="Control?origin=showActiveCampaigns"/>Active campaigns</a></li>
                            <li><a href="Control?origin=showInactiveCampaigns"/>Inactive campaigns</a></li>
                            <li><a href="registration.jsp">Create partner</a></li>
                            <li><a href="Control?origin=showPartners">Partner list</a></li>
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
            <%--partner.userid - partner kommer fra servletten, under den case som sender videre til editPartnersiden,
            og userid kommer fra Partner klassen, som er lavet som en bean, og derfor kan vi få fat i getters/setters..--%>
            <h1>Edit partner</h1>
            <form action="Control" method="POST">              
                <table>
                    <tbody>
                        <tr>
                            <td><label>User ID</label></td>
                            <td><input type="text" name="userid" value="${partner.userid}" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td><label>Partner ID</label></td>
                            <td><input type="text" name="partnerid" value="${partner.partnerid}" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td><label>Partner name</label></td>
                            <td><input type="text" name="partnername" value="${partner.partnername}"></td>
                        </tr>
                        <tr>
                            <td><label>Address</label></td>
                            <td><input type="text" name="address" value="${partner.address}" required></td>
                        </tr>
                        <tr>
                            <td><label>Zip</label></td>
                            <td><input type="text" name="zip" value="${partner.zip}" required></td>
                        </tr>
                        <tr>
                            <td><label>City</label></td>
                            <td><input type="text" name="city" value="" required></td>
                        </tr>
                        <tr>
                            <td><label>CVR-number</label></td>
                            <td><input type="text" name="cvr" value="${partner.cvr}" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td><label>Phone number</label></td>
                            <td><input type="text" name="phone" value="${partner.phone}" required></td>
                        </tr>
                        <tr>
                            <td><label>Password</label></td>
                            <td><input type="password" name="password" value="" required></td>
                        </tr>
                        <tr>
                            <td><label>Retype password</label></td>
                            <td><input type="password" name="retype_password" value="" required></td>
                        </tr>
                        <tr>
                            <td><button class="btn btn-primary" name="origin" value="editPartnerDB">Edit</button></td>
                        </tr>

                    </tbody>
                </table>       
            </form>

            <!-- Site footer -->
            <footer class="footer">
                <p>&copy; Dell 2015</p>
            </footer>
        </div>       
    </body>
</html>
