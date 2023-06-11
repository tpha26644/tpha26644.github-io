<%-- 
    Document   : list
    Created on : Feb 14, 2022, 11:38:19 PM
    Author     : Linh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Account ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Role</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list_account}" var="a">
                    <tr>
                        <td>${a.getAccountID()}</td>
                        <td>${a.getUsername()}</td>
                        <td>${a.getPassword()}</td>
                        <td>${a.getRole().getName()}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </body>
</html>
