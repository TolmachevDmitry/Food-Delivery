<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="com.tolmic.fooddeliveryservlet.entities.Order" %>
<%@ page import="com.tolmic.fooddeliveryservlet.entities.Dish" %>

<%@ page import="java.util.List" %>
<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html> 

<html>
    <head>
        <meta charset="UTF-8">
    </head>

    <body>
        <div>
            <h1>Моя карзина</h1>
        </div>

        <div class="non-delivered-orders" >
            <ol class="orders-list" >
                <c:forEach var="order" items="${requestScope.orders}" >
                    <c:if test="${!order.isDelivered()}">
                        <li>
                            ${order.getDish().getName()}
                        </li>
                    </c:if>
                </c:forEach>
            </ol>
        </div>

        <div class="delivered-orders" >
            <ol class="orders-list" >
                <c:forEach var="order" items="${requestScope.orders}" >
                    <c:if test="${order.isDelivered()}">
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
                    </c:if>
                </c:forEach>
            </ol>
        </div>

    </body>
</html>