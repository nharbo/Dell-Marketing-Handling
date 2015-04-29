<%-- 
    Document   : campaignRequest
    Created on : 15-04-2015, 09:27:06
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap core CSS -->
        <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

        <%-- Link til CSS style filen. --%>
        <link type="text/css" rel="stylesheet" href="StyleDashboard.css"/>

        <title>Partner Dashboard</title>
    </head>
    <body>
        <div class="container">

            <div class="masthead">
                <h3 class="text-muted">Dell</h3>
                <nav>
                    <ul class="nav nav-justified">
                        <li><a href="Control?origin=showCampaignReqSite">Request a new campaign</a></li>
                        <li><a href="Control?origin=showPartnerCampaigns"/>Show your campaigns</a></li>
                        <li><a href="Control?origin=logout"/>Logout</a></li>
                    </ul>
                </nav>
            </div>

            <!-- Jumbotron -->
            <div class="jumbotron">
                <h1>Dell marketing</h1>
                <p class="lead"></p>
            </div>
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

                                if (option == "Danmark") {
                                    document.getElementById('currencyField').value = "DKK";
                                }
                                else if (option == "Norge") {
                                    document.getElementById('currencyField').value = "NOK";
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
                            <option id="Danmark" value="Danmark">Danmark</option>
                            <option id="Norge" value="Norge">Norge</option>
                            <option id="Sverige" value="Sverige">Sverige</option>
                            <option id="Island" value="Island">Island</option>
                            <option id="Finland" value="Finland">Finland</option>
                            <option id="USA" value="USA">USA</option>
                        </select>
                    </div>
                    <div>
                        Currency: <br><input type="text" id="currencyField" name="currency" readonly="readonly" value="DKK">
                    </div>
                    <div>
                        Campaign Id:
                        <br><input type="text" name="campaignId">
                    </div>
                    <div>
                        Partner Id:                      
                        <br><input type="text" name="partnerId" value="${partner.partnerid}" readonly="readonly">
                    </div>

                    <button class="button" id="currencyField" name="origin" value="campaignRequest">Request campaign!</button>
            </form>
        </div>


        <div id="bottom">

        </div>
    </body>
</html>
