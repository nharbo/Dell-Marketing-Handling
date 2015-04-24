<%-- 
    Document   : campaignRequest
    Created on : 15-04-2015, 09:27:06
    Author     : Daniel
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
                        <script type="text/javascript">
                            function changeValue() {
                                var option = document.getElementById('country').value;

                                if (option == "Norge") {
                                    document.getElementById('currencyField').value = "NOK";
                                }
                                else if (option == "Danmark") {
                                    document.getElementById('currencyField').value = "DKK";
                                }
                                else if (option == "Sverige") {
                                    document.getElementById('currencyField').value = "SEK";
                                }
                                else if (option == "Island") {
                                    document.getElementById('currencyField').value = "Islaaandsk mønt";
                                }
                                else if (option == "Finland") {
                                    document.getElementById('currencyField').value = "Finska mønt";
                                }
                                else if (option == "USA") {
                                    document.getElementById('currencyField').value = "USD";
                                }

                            }
                        </script>
                        Country:
                        <br><select name="country" id="country" onchange="changeValue();">
                            <option id="Norge" value="Norge">Norge</option>
                            <option id="Danmark" value="Danmark">Danmark</option>
                            <option id="Sverige" value="Sverige">Sverige</option>
                            <option id="Island" value="Island">Island</option>
                            <option id="Finland" value="Finland">Finland</option>
                            <option id="USA" value="USA">USA</option>
                        </select>
                    </div>
                    <div>
                        Currency: <br><input type="text" id="currencyField" name="currency" readonly="readonly" value="NOK">
                    </div>
                    <div>
                        Campaign Id:
                        <br><input type="text" name="campaignId">
                    </div>
                    <div>
                        Partner Id:
                        <br><input type="text" name="partnerId">
                    </div>

                    <button class="button" id="currencyField" name="campaignRequest" value="">Request campaign!</button>
                    <input type="hidden" name="origin" value="campaignRequest">
                    </form>
                </div>


                <div id="bottom">

                </div>
                </body>
                </html>
