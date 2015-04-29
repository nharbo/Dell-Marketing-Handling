<%-- 
    Document   : registration
    Created on : Mar 23, 2015, 10:04:44 AM
    Author     : nicolaiharbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <title>Partner registration</title>
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
            <h1>Partner registration</h1>
            <form action="Control" method="POST">
                <input type="image" id="myimage" src="dell round logo.png" width="150" height="150" alt="dell-logo" name="origin" value="homebutton"/>
            </form>
        </div>
        <div id="middle">
            <form action="Control" method="POST">
                <table border="0" width="1" cellspacing="1">
                    <tbody>
                        <tr>
                            <td><label>UserID</label></td>
                            <td><input type="text" name="userid"></td>
                        </tr>
                        <tr>
                            <td><label>PartnerID</label></td>
                            <td><input type="text" name="partnerid"></td>
                        </tr>
                        <tr>
                            <td><label>Partner name</label></td>
                            <td><input type="text" name="partnername"></td>
                        </tr>
                        <tr>
                            <td><label>Address</label></td>
                            <td><input type="text" name="address"></td>
                        </tr>
                        <tr>
                            <td><label>Zip</label></td>
                            <td><input type="text" name="zip"></td>
                        </tr>
                        <tr>
                            <td><label>City</label></td>
                            <td><input type="text" name="city"></td>
                        </tr>
                        <tr>
                            <td><label>CVR-number</label></td>
                            <td><input type="text" name="cvr"></td>
                        </tr>
                        <tr>
                            <td><label>Phone number</label></td>
                            <td><input type="text" name="phone"></td>
                        </tr>
                        <tr>
                            <td><label>Password</label></td>
                            <td><input type="password" name="password"></td>
                        </tr>
                        <tr>
                            <td><label>Retype password</label></td>
                            <td><input type="password" name="retype_password"></td>
                        </tr>
                        <tr>
                            <td><button name="origin" value="registration">Create</button></td>
                        </tr>

                    </tbody>
                </table>        
            </form>
        </div>
        <div id="bottom">

        </div>
    </body>
</html>
