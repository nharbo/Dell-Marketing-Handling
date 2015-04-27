<%-- 
    Document   : showPOE
    Created on : Apr 22, 2015, 10:11:47 AM
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
        <title>Accept or decline POE</title>
    </head>
    <body>
        <div id="header">

        </div>
        <div id="middle">
            <h1>
                <form action="Control" method="POST">
                    <input type="image" id="myimage" src="dell round logo.png" width="150" height="150" alt="dell-logo" name="origin" value="homebutton"/>
                </form>
                <%=session.getAttribute("message")%>
            </h1>

            <img src="ImgServlet?poeID=?${image.poe}"/>

        </div>
        <div id="bottom">



        </div>
    </body>
</html>
