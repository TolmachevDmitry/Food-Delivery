<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="com.tolmic.fooddeliveryservlet.entities.Order" %>
<%@ page import="com.tolmic.fooddeliveryservlet.entities.Dish" %>

<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html> 

<html>
    <head>
        <meta charset="UTF-8">
        <title>Курьеры</title>
    </head>

    <body>
        <div>
            <h1>Курьеры</h1>
        </div>

        <div class="couriers-list" >
            <ul>
                <c:forEach var="courier" items="${couriers}" >
                    <li>
                        <p>${courier.getName()} ${courier.getSurname()} </p>

                        <form class="send-on-vocation-form" >
                            <input type="hidden" name="courierId" value="${courier.getId()}" />
                            
                            <input type="submit" value="Отправить в отпуск" />
                        </form>

                        <form class="fire-form" >
                            <input type="hidden" name="courierId" value="${courier.getId()}" />
                            
                            <input type="submit" value="Уволить" />
                        </form>
                    </li>
                </c:forEach>
            </ul>

        <div class="registrate-courier" >
            <a href="/couriers/create" >Зарегестрировать курьера</a>
        </div>

    </body>
</html>