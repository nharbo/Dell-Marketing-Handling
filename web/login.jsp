<%-- 
    Document   : login
    Created on : Mar 23, 2015, 10:04:53 AM
    Author     : nicolaiharbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%-- Link til CSS style filen. --%>
        <link type="text/css" rel="stylesheet" href="HillerStyle.css"/>

        <title>Dell login</title>
    </head>
    <body>
        <div id="header">
            <h1>Welcome to Dell login page</h1>
            <img src="dell round logo.png" width="150" height="150" alt="dell round logo"/>          
        </div>
        <div id="middle">
            <form action="Control" method="POST">
                <div id="username">
                    Username:
                    <br><input type="text" name="username">
                </div>
                <div id="password">
                    Password:
                    <br><input type="password" name="password" >
                </div>
                <button class="button" name="login" value="" id="login">Login</button>
                <input type="hidden" name="origin" value="login">
                <input type="hidden" name="origin" value="showPartnerCampaigns">
            </form>
        </div>
        <div id="bottom">

        </div>
    </body>
</html>
