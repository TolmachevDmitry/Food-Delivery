<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="com.tolmic.fooddeliveryservlet.entities.Order" %>
<%@ page import="com.tolmic.fooddeliveryservlet.entities.Dish" %>

<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html> 

<html>
    <head>
        <meta charset="UTF-8">
        <title>Администратор</title>
    </head>

    <body>
        <div>
            <h1>Администратор</h1>
        </div>

        <div class="dish-links" >
            <a href="/dishes" >Список блюд</a>  
            
            <a href="/dishes/create" >Создать блюдо</a>

            <a href="/ingredients" >Список ингредиентов</a>

            <a href="/ingredients/create" >Создать ингредиент</a>
        </div>

        <div class="courier-links" >
            <a href="/cuirers" >Список курьеров</a>

            <a href="/cuirers/create" >Зарегестрировать курьера</a>
        </div>

    </body>
</html>