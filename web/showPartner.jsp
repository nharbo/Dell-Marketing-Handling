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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="DashBoardStyle.css" type="text/css">
        <title>Partners</title>
    </head>
    <body>

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
</body>
</html>
