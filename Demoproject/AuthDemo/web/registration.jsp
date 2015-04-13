<%-- 
    Document   : registration
    Created on : 18-02-2015, 14:46:17
    Author     : tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please Register!</h1>
        
        <form name="Form1" action="Control" method="POST">
        <table>
             <tr><td>Input ID</td><td> <input type="text" name="id" value="" /></td></tr>
             <tr><td>Input Name</td><td><input type="text" name="name" value="" /></td></tr>
             <tr><td>Input Password</td><td><input type="text" name="password" value="" /></td></tr>
             <tr><td>Input Gender</td><td><input type="text" name="gender" value="" /></td></tr>
             <input type="hidden" name="origin" value="registration" />
             <tr><td></td><td><input type="submit" value="Submit" /></td></tr>
             
        </table>
        </form>
    </body>
</html>
