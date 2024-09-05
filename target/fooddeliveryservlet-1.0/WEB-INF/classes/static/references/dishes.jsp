<!DOCTYPE html>

<html>

    <head>
        <meta charset="utf-8">
        <title>Блюда</title>
    </head>

    <body>
        <div class="dish-list" >
            <ol>
                <% for (Dish dish : dishes) { %>
                    <li>
                        <p><%= dish.getName() %> <%= dish.getPrice() %> руб.</з>
                    </li>
                <% } %>
            </ol>
        </div>
    </body>

</html>