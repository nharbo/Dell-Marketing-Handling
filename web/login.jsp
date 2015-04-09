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
        <link type="text/css" rel="stylesheet" href="LoginStyle.css"/>

        <title>Dell login</title>
    </head>
    <body>
        <div id="header">
            <h1>Welcome to Dell login page</h1>
            <img src="dell round logo.png" width="150" height="150" alt="dell round logo"/>
            <h1>
                <p><%=session.getAttribute("message")%></p>
            </h1>
        </div>
        <div id="middle">
            <form id="username">
                Username:
                <br><input type="text" name="username" >               
            </form>
            <form id="password">
                password:
                <br><input type="password" name="password" >
            </form>
            <button class="Button" name="login" value="" id="login">
                Login
            </button>
        </div>
        <div id="bottom">

        </div>
    </body>
</html>
