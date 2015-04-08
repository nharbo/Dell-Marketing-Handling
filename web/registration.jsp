<%-- 
    Document   : registration
    Created on : Mar 23, 2015, 10:04:44 AM
    Author     : nicolaiharbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new partner</title>
    </head>
    <body>
        <form action="Control" method="POST">
            <table border="0" width="1" cellspacing="1">
                <tbody>
                    <tr>
                        <td><label>Partner name</label></td>
                        <td><input type="text" name="partnername"></td>
                    </tr>
                    <tr>
                        <td><label>Address</label></td>
                        <td><input type="text" name="address"></td>
                    </tr>
                    <tr>
                        <td><label>Zipcode</label></td>
                        <td><input type="text" name="zipcode"></td>
                    </tr>
                    <tr>
                        <td><label>City</label></td>
                        <td><input type="text" name="city"></td>
                    </tr>
                    <tr>
                        <td><label>Phone</label></td>
                        <td><input type="text" name="phone"></td>
                    </tr>
                    <tr>
                        <td><label>Partner ID</label></td>
                        <td><input type="text" name="partnerid"></td>
                    </tr>
                    <tr>
                        <td><label>Password</label></td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td><label>Retype password</label></td>
                        <td><input type="password" name="retype_password"></td>
                    </tr>
                    <tr>
                        <td><button name="signup" value="">Create</button></td>
                    </tr>

                </tbody>
            </table>

            <input type="hidden" name="origin" value="registration">         

        </form>
    </body>
</html>
