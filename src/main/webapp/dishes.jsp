<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.tolmic.fooddeliveryservlet.entities.Dish" %>

<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html>

    <head>
        <meta charset="utf-8" >
        <title>Блюда</title>

        <script src="./static/scripts/dish-delete-script.js" defer></script>
    </head>

    <body>
        <h1>Блюда</h1>

        <div>
            <o>
                <c:forEach var="dish" items="${dises}" >
                    <li>
                        <p>${dish.getName()} ${dish.getPrice()} руб.</p>

                        <c:if test="${role.equals('ADMIN')}">
                            <form class="dish-delete-form" >
                                <input type="hidden" name="dishId" value="${dish.getId()}" />
    
                                <input type="submit" value="Удалить" />
                            </form>
                        </c:if>

                        <c:if test="${role.equals('CONSUMER')}">
                            <form class="dish-delete-form" >
                                <input type="hidden" name="dishId" value="{dish.getId()}" />
                                <input type="hidden" name="consumerId" value="${user.getId()}" />

                                <input type="number" name="count" />
    
                                <input type="submit" value="Заказать" />
                            </form>
                        </c:if>

                    </li>
                </c:forEach>
            </ol>
        </div>

        <div class="dish-create">
            <a href="/Food Delivery Application/dishes/create" >Создать блюдо</a>
        </div>

    </body>

</html>