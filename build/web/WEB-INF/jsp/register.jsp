

<%-- 
    Document   : shoppingList
    Created on : 8-Oct-2022, 6:26:40 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body style="text-align: center">
        <h1>Shopping List</h1>
        <form method="POST" action="ShoppingList">
            <label>Username: </label>
            <input type="text" name="username" required>
            <input type="submit" value="Register name" >
            <input type="hidden" name="action" value="register">
        </form>
    </body>
</html>

