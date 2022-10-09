<%-- 
    Document   : account
    Created on : 8-Oct-2022, 6:35:55 PM
    Author     : nguye
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping list Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${sessionScope.username}</p>
        <a href="ShoppingList?logout">Log out</a>
        <h4>List</h4>
        <form method="POST" action="ShoppingList">
            <label>Add item: </label>
            <input type="text" name="item" required>
            <input type="submit" value="Add">
        </form>
        <div>

            <c:forEach items="${sessionScope.itemList}" var="item">
                <div>
                    <label><c:out value="${item}" /></label>
                    <input type="checkbox">
                </div>
                <br>
            </c:forEach>

        </div>
    </body>
</html>