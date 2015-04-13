<%-- 
    Document   : showusers
    Created on : 18-02-2015, 06:26:43
    Author     : tha
--%>
<%! int fontSize;%> 
<%@page import="Model.User, java.util.List, java.util.ArrayList, java.util.Iterator, java.util.Enumeration"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/styles.css" rel="stylesheet"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="container">
        <a href='Control?origin=allusers'>Show all users</a>

        
            <div id="users"><h3>Users:</h3>
            <table>
                <c:forEach var="user" items="${requestScope.users}">
                    <c:choose>
                        <c:when test="${user.gender == 'M'}"><tr class="red"></c:when>
                        <c:when test="${user.gender == 'F'}"><tr class="blue"></c:when> 

                        </c:choose>
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.gender}"/></td>
                        <td><c:out value="${user.pwd}"/></td>
                    </tr>
                </c:forEach>
            </table></div>
        </div id="container">
    </body>
</html>
