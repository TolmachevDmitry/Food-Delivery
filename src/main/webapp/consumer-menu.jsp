<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="com.tolmic.fooddeliveryservlet.entities.Order" %>
<%@ page import="com.tolmic.fooddeliveryservlet.entities.Dish" %>

<%@ page import="java.util.List" %>

<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html> 

<html>
    <head>
        <meta charset="UTF-8">
        <title>${surname} ${name}</title>
    </head>

    <body>

        <div>
            <h1>Мой личный кабинет</h1>
        </div>
    
        <div class="personal-datas" >
            <div class="parameter" >
                <label>Имя:</label>
                <p>${name}</p>
            </div>

            <div class="parameter" >
                <label>Фамилия:</label>
                <p>${surname}</p>
            </div>

            <div class="parameter" >
                <label>Город:</label>
                <p>${city}</p>
            </div>
        </div>

        <div class="non-delivered-orders" >
            <ol class="orders-list" >
                <c:forEach var="order" items="${requestScope.nonDeliveredOrders}" >
                    <li>
                        ${order.getDish().getName()}
                    </li>
                </c:forEach>
            </ol>
        </div>

        <div class="delivered-orders" >
            <ol class="orders-list" >
                <c:forEach var="order" items="${requestScope.deliveredOrders}" >
                    <li>
                        ${order.getDish().getName()}
                        
                        <c:if test="${order.getStarGrade() == null}" >
                            <form class="grade-form" >
                                <input type="hidden" name="dishId" value="${order.getId()}" />
    
                                <input name="starGradeNumber" list="values" />
                                <datalist id="values" >
                                    <c:forEach var="num" items="${new int[] {1, 2, 3, 4, 5} }" >
                                        <option value="${num}" ></option>
                                    </c:forEach>
                                </datalist>
    
                                <input type="submit" value="Оценить" />
                            </form>
                        </c:if>

                    </li>
                </c:forEach>
            </ol>
        </div>

    </body>
</html>