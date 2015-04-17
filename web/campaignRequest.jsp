<%-- 
    Document   : campaignRequest
    Created on : 15-04-2015, 09:27:06
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link type="text/css" rel="stylesheet" href="HillerStyle.css"/>

        <title>Campaign request</title>
    </head>
    <body>
        <div id="header">
            <h1>Campaign request</h1>
            <img src="dell round logo.png" width="150" height="150" alt="dell round logo"/>
        </div>
        <div id="middle">
            <form action="Control" method="POST">
                <div class="campaignInputs">
                    <div>
                        Startdate:
                        <br><input type="date" name="startDate">
                    </div>
                    <div class="campaignInputs">
                        Enddate:
                        <br><input type="date" name="stopDate">
                    </div>
                    <div>
                        Budget:
                        <br><input type="text" name="budget">
                    </div>
                    <div>
                        Country:
                        <br><input type="text" name="country">
                    </div>
                    <div>
                        Currency:
                        <br><input type="text" name="currency" value="">
                    </div>
                    <div>
                        Campaign Id:
                        <br><input type="text" name="campaignId">
                    </div>
                    <div>
                        Partner Id:
                        <br><input type="text" name="partnerId">
                    </div>

                    <button class="button" name="campaignRequest" value="">Request campaign!</button>
                    <input type="hidden" name="origin" value="campaignRequest">
                    </form>
                </div>
                <div id="bottom">

                </div>
                </body>
                </html>
