<%-- 
    Document   : requests
    Created on : Apr 20, 2015, 12:09:10 PM
    Author     : nicolaiharbo
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Campaign requests</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">
            <h1>Approve or disapprove campaign requests</h1>
            <p>This is some text.</p>
        </div>
        <table style="border: 1px solid #0066cc">

            <thead>
            <th>
                Campaign id
            </th>
            <th>
                Partner id
            </th>
            <th>
                Startdate
            </th>
            <th>
                Stopdate
            </th>
            <th>
                Requested campaign budget
            </th>
            <th>
                Status
            </th>
            <th>
                Country
            </th>
        </thead>



        <c:forEach var="campaignRequests" items="${campaignList}">
            <tr>
                <td style="border: 1px solid #0066CC">${campaign.campaignid}</td>
                <td style="border: 1px solid #0066CC">${campaign.partnerid}</td>
                <td style="border: 1px solid #0066CC">${campaign.startdate}</td>
                <td style="border: 1px solid #0066CC">${campaign.stopdate}</td>
                <td style="border: 1px solid #0066CC">${campaign.budget}</td>
                <td style="border: 1px solid #0066CC">${campaign.status}</td>
                <td style="border: 1px solid #0066CC">${campaign.country}</td>
            </tr>

        </c:forEach>
    </table>
</body>
</html>
