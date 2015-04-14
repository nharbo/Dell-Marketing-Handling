<%-- 
    Document   : showPartner
    Created on : 14-04-2015, 09:12:49
    Author     : Florent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="DashBoardStyle.css" type="text/css">
        <title>Partners</title>
    </head>
    <body>
        <a href="Control?origin=showActiveCampaigns"></a>

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
                <td style="border: 1px solid #0066CC">${partner.userid}</td>
                <td style="border: 1px solid #0066CC">${partner.partnerid}</td>
                <td style="border: 1px solid #0066CC">${partner.partnername}</td>
                <td style="border: 1px solid #0066CC">${partner.address}</td>
                <td style="border: 1px solid #0066CC">${partner.cvr}</td>
                <td style="border: 1px solid #0066CC">${partner.phone}</td>
                <td style="border: 1px solid #0066CC">${partner.zip}</td>
            </tr>

        </c:forEach>
    </table>
</body>
</html>
