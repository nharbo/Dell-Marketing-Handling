<%-- 
    Document   : home
    Created on : Mar 23, 2015, 10:05:13 AM
    Author     : nicolaiharbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=session.getAttribute("message")%></h1>
    </body>
</html>
