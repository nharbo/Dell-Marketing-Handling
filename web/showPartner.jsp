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
        <link type="text/css" rel="stylesheet" href="HillerStyle.css"/>
        <title>Partners</title>
    </head>
    <body>
        <div id="header">
            
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
        <table border="0">
            <tbody>
                <tr>
                    <th> <input type="text" name="useridDelete" value="Type partner id here" />
                    </th>
                    <th><input class="DButton" type="submit" value="Delete Partner" name="slet"></th>
                </tr>
            </tbody>
        </table>
        <input type="hidden" name="origin" value="deletePartner">
    </form>
    <form action="Control" method="POST">
        <table border="0">
            <tbody>
                <tr>
                    <th> <input type="text" name="useridEdit" value="Type partner id here" />
                    </th>
                    <th><input class="DButton" type="submit" value="Edit Partner" name="editPartner"></th>
                </tr>
            </tbody>
        </table>
        <input type="hidden" name="origin" value="editPartnerPage">
    </form>
        </div>
        <div id="bottom">
            
        </div>
</body>
</html>
