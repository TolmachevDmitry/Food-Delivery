<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8" >
        <title>Регистрация</title>

    </head>

    <body>

        <form action="/Food Delivery Application/registration" method="post" >

            <div class="parameter" > 
                <label>Имя</label>
                <input required type="text" name="name" />
            </div>

            <div class="parameter" >
                <label>Фамилия</label>
                <input required type="text" name="surname" />
            </div>

            <div class="parameter" >
                <label>Город</label>
                <input required type="text" name="city" />
            </div>

            <div class="parameter" >
                <label>Дата рождения</label>
                <input required type="date" name="birthday" />
            </div>

            <div class="parameter" >
                <label>Логин</label>
                <input required type="text" name="login" />
            </div>
    
            <div class="parameter" >
                <label>Пароль</label>
                <input required type="password" name="password" />
            </div>

            <input type="submit" value="Зарегистрироваться" />
        </form>

        <div class="error" >
            <% 
                String error = (String) request.getAttribute("error");
                if (error != null) {
                    out.println("<p>" + error + "</p>");
                }
             %>
        </div>

    </body>
</html>