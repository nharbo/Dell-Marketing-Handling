<%-- 
    Document   : login
    Created on : 17-02-2015, 11:16:42
    Author     : tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Please log in:
        <form name="Form1" action="Control" method="POST">
            <input type="text" name="id" value="" />
            <input type="password" name="pwd" value="" />
            <input type="hidden" name="origin" value="login" />
            <input type="submit" value="Submit" name="submit" />
        </form>
    </body>
</html>
