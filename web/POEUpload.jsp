<%-- 
    Document   : POEUpload
    Created on : 20-04-2015, 12:37:47
    Author     : Florent
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
        <link type="text/css" rel="stylesheet" href="StyleGeneral.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <form action="Control" method="POST">
                <input type="image" id="myimage" src="dell round logo.png" width="150" height="150" alt="dell-logo" name="origin" value="homebuttonPartner"/>
            </form>
        </h1>
        <div id="header">

        </div>
        <div id="middle">
            <form action="Control" method="POST" enctype="multipart/form-data" name="Poeup">
                <%-- Campaign ID skal helst selv fyldes ud når du kommer ind på denne side, indtil videre skal det gøres manuelt --%>
                POEID: <input type="text" name="POEID">
                CampaignID: <input type="text" name="CampaignID">

                Attach POE FILE: <input type="file" name="POEFile">
                <button type="submit" name="origin" value="POEUpload">Submit</button>
        </div>
        <div id="bottom">

        </div>

    </form>
</body>
</html>
