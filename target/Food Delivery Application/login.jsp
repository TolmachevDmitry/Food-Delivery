<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8" >

        <title>Вход</title>

    </head>

    <body>

        <div>
            <h1>Вход</h1>
        </div>

        <form>
            <div>
                <label>Логин</label>
                <input type="text" name="login" />
            </div>
    
            <div>
                <label>Пароль</label>
                <input type="text" name="password" />
            </div>

            <input type="submit" value="Войти" />
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