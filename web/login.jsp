<%-- 
    Document   : login
    Created on : Mar 23, 2015, 10:04:53 AM
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
        <link type="text/css" rel="stylesheet" href="cssStyle.css"/>

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
                <button class="button" name="loorigingin" value="login" id="login">Login</button>
            </form>
        </div>
        <div id="bottom">

        </div>
    </body>
</html>
