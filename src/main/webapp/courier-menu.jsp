<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="com.tolmic.fooddeliveryservlet.entities.Order" %>
<%@ page import="com.tolmic.fooddeliveryservlet.entities.Dish" %>

<%@ page import="java.util.List" %>
<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html> 

<html>
    <head>
        <meta charset="UTF-8">
        <title>Курьер</title>
    </head>

    <body>
        <div>
            <h1>Моя карзина</h1>
        </div>

        <div class="orders" >
            <ol class="orders-list" >
                <c:forEach var="order" items="${requestScope.nonDeliveredOrders}" >
                    <li>
                        ${order.getDish().getName()}

                        <form class="set-delivered-status-form" action="" >
                            <input type="hidden" name="orderId" value="${order.getId()}" />

                            <input type="submit" value="Доставлен" />
                        </form>
                    </li>
                </c:forEach>
            </ol>
        </div>

    </body>
</html>