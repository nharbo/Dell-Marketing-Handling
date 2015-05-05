
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
        <title>POE</title>
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
                <h2></h2>
                <p class="lead"></p>
            </div>
            <h1>POE upload</h1>
            <form action="Control" method="POST" enctype="multipart/form-data" name="Poeup">
                <table>
                    <tr>
                        <td>POE-ID</td>
                        <td><input type="text" name="POEID" required></td>
                    </tr>
                    <tr>
                        <td>Campaign ID</td>
                        <td><input type="text" name="CampaignID" value="<%=session.getAttribute("campaignid")%>" readonly></td>
                    </tr>
                    <tr>
                        <td>Attach file</td>
                        <td><input type="file" name="POEFile"></td>
                    </tr>
                </table>
                <button class="btn btn-primary" type="submit" name="origin" value="POEUpload">Submit</button>
            </form>
            <!-- Site footer -->
            <footer class="footer">
                <p>&copy; Dell 2015</p>
            </footer>
        </div>
    </body>
</html>
