<%-- 
    Document   : registration
    Created on : Mar 23, 2015, 10:04:44 AM
    Author     : nicolaiharbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link type="text/css" rel="stylesheet" href="HillerStyle.css"/>
        
        <title>Partner registration</title>
    </head>
    <body>
        <div id="header">
            <h1>Partner registration</h1>
            <img src="dell round logo.png" width="150" height="150" alt="dell round logo"/>
        </div>
        <div id="middle">
            <%--HVAD GØR C:OUT??--%>
            <h1><c:out value=""></c:out></h1>
            
                            <c:forEach var="campaign" items="${campaignList}">
                    <tr>
                        <td style="border: 1px solid #0066CC">${campaign.campaignId}</td>
                        <td style="border: 1px solid #0066CC">${campaign.partnerId}</td>
                        <td style="border: 1px solid #0066CC">${campaign.startDate}</td>
                        <td style="border: 1px solid #0066CC">${campaign.stopDate}</td>
                        <td style="border: 1px solid #0066CC">${campaign.budget}</td>
                        <td style="border: 1px solid #0066CC">${campaign.status}</td>
                    </tr>

                </c:forEach>
            
            <form action="Control" method="POST">              
                <table border="0" width="1" cellspacing="1">
                    <tbody>
                        <tr>
                            <td><label>UserID</label></td>
                            <td><input type="text" name="userid" value="${partner.partnerId}"></td>
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
                            <td><button name="signup" value="">Edit</button></td>
                        </tr>

                    </tbody>
                </table>
                <input type="hidden" name="origin" value="editPartner">         
            </form>
        </div>
        <div id="bottom">

        </div>
    </body>
</html>
