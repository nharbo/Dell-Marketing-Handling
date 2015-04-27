<%-- 
    Document   : registration
    Created on : Mar 23, 2015, 10:04:44 AM
    Author     : nicolaiharbo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link type="text/css" rel="stylesheet" href="cssStyle.css"/>

        <title>Partner edit</title>
    </head>
    <body>
        <div id="header">
            <h1>Partner edit</h1>
            <form action="Control" method="POST">
                <input type="image" id="myimage" src="dell round logo.png" width="150" height="150" alt="dell-logo" name="origin" value="homebutton"/>
            </form>
        </div>
        <div id="middle">

            <h1></h1>

            <%--partner.userid - partner kommer fra servletten, under den case som sender videre til editPartnersiden,
            og userid kommer fra Partner klassen, som er lavet som en bean, og derfor kan vi få fat i getters/setters..--%>
            <form action="Control" method="POST">              
                <table border="0" width="1" cellspacing="1">
                    <tbody>
                        <tr>
                            <td><label>UserID</label></td>
                            <td><input type="text" name="userid" value="${partner.userid}" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td><label>PartnerID</label></td>
                            <td><input type="text" name="partnerid" value="${partner.partnerid}" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td><label>Partner name</label></td>
                            <td><input type="text" name="partnername" value="${partner.partnername}"></td>
                        </tr>
                        <tr>
                            <td><label>Address</label></td>
                            <td><input type="text" name="address" value="${partner.address}"></td>
                        </tr>
                        <tr>
                            <td><label>Zip</label></td>
                            <td><input type="text" name="zip" value="${partner.zip}"></td>
                        </tr>
                        <tr>
                            <td><label>City</label></td>
                            <td><input type="text" name="city" value=""></td>
                        </tr>
                        <tr>
                            <td><label>CVR-number</label></td>
                            <td><input type="text" name="cvr" value="${partner.cvr}" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td><label>Phone number</label></td>
                            <td><input type="text" name="phone" value="${partner.phone}"></td>
                        </tr>
                        <tr>
                            <td><label>Password</label></td>
                            <td><input type="password" name="password" value=""></td>
                        </tr>
                        <tr>
                            <td><label>Retype password</label></td>
                            <td><input type="password" name="retype_password" value=""></td>
                        </tr>
                        <tr>
                            <td><button name="origin" value="editPartnerDB">Edit</button></td>
                        </tr>

                    </tbody>
                </table>       
            </form>
        </div>
        <div id="bottom">

        </div>
    </body>
</html>
