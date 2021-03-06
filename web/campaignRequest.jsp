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
                        <li><a href="Control?origin=homebuttonPartner">Home</a></li>
                        <li><a href="Control?origin=showCampaignReqSite">Request a new campaign</a></li>
                        <li><a href="Control?origin=showPartnerCampaigns"/>Show your campaigns</a></li>
                        <li><a href="Control?origin=logout"/>Logout</a></li>
                    </ul>
                </nav>
            </div>

            <!-- Jumbotron -->
            <div class="jumbotron">
                <p class="lead">    
                </p>
            </div>

            <h1>Campaign request</h1>
            <form action="Control" method="POST">
                <table>
                    <tbody>
                        <tr>
                            <td>Startdate</td>
                            <td><input type="date" name="startDate" required></td>
                        </tr>
                        <tr>
                            <td>Enddate</td>
                            <td><input type="date" name="stopDate" required></td>
                        </tr>
                        <tr>
                            <td>Budget</td>
                            <td><input type="text" name="budget" required></td>
                        </tr>
                        <tr>
                            <td>Country</td>
                            <td><select name="country" id="country" onchange="changeValue();">
                                    <option id="Denmark" value="Denmark">Denmark</option>
                                    <option id="Norway" value="Norway">Norway</option>
                                    <option id="Sweden" value="Sweden">Sweden</option>
                                    <option id="Iceland" value="Iceland">Iceland</option>
                                    <option id="Finland" value="Finland">Finland</option>
                                    <option id="USA" value="USA">USA</option></td>
                        </tr>
                        <tr>
                            <td>Currency</td>
                            <td><input type="text" id="currencyField" name="currency" readonly="readonly" value="DKK"></td>
                        </tr>
                        <tr>
                            <td>Campaign ID</td>
                            <td><input type="text" name="campaignId" required></td>
                        </tr>
                        <tr>
                            <td>Partner ID</td>
                            <td><input type="text" name="partnerId" value="${partner.partnerid}" readonly="readonly"></td>
                        </tr>

                    </tbody>
                </table>
                <button class="btn btn-primary" id="currencyField" name="origin" value="campaignRequest">Request campaign!</button>
            </form>


            <script type="text/javascript">
                function changeValue() {
                    var option = document.getElementById('country').value;

                    if (option == "Denmark") {
                        document.getElementById('currencyField').value = "DKK";
                    }
                    else if (option == "Norway") {
                        document.getElementById('currencyField').value = "NOK";
                    }
                    else if (option == "Sweden") {
                        document.getElementById('currencyField').value = "SEK";
                    }
                    else if (option == "Iceland") {
                        document.getElementById('currencyField').value = "ISK";
                    }
                    else if (option == "Finland") {
                        document.getElementById('currencyField').value = "EUR";
                    }
                    else if (option == "USA") {
                        document.getElementById('currencyField').value = "USD";
                    }

                }
            </script>
            <!-- Site footer -->
            <footer class="footer">
                <p>&copy; Dell 2015</p>
            </footer>
        </div>
    </body>
</html>
