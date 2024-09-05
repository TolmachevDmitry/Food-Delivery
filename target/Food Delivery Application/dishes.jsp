<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.tolmic.fooddeliveryservlet.entities.Dish" %>

<!DOCTYPE html>

<html>

    <head>
        <meta charset="utf-8" >
        <title>Блюда</title>

        <script src="./static/scripts/dish-delete-script.js" defer></script>
    </head>

    <body>
        <h1>Блюда</h1>

        <%
            List<Dish> dishes = (List) request.getAttribute("dishes");
        %>

        <div>
            <ol>
                <% for (Dish dish : dishes) { %>
                    <li>
                        <p><%= dish.getName() %> <%= dish.getPrice() %> руб.</p>

                        <form class="dish-delete-form" >
                            <input type="hidden" name="${dish.getId()}" value="" />

                            <input type="submit" value="Удалить" />
                        </form>
                    </li>
                <% } %>
            </ol>
        </div>

        <div class="dish-create">
            <a href="/Food Delivery Application/dishes/create" >Создать блюдо</a>
        </div>

    </body>

</html>