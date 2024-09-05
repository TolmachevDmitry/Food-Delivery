package com.tolmic.fooddeliveryservlet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tolmic.fooddeliveryservlet.entities.Dish;
import com.tolmic.fooddeliveryservlet.services.DishService;


@WebServlet( urlPatterns = { "/dishes", "/dishes/create", "/dishes/delete" } )
public class DishServlet extends HttpServlet {

    private DishService dishService = new DishService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        setRequestAndResponseToUTF8(request, response);

        String servletPath = request.getServletPath();

        if (servletPath.equals("/dishes")) {
            
            request.setAttribute("dishes", dishService.findAll());
            getServletContext().getRequestDispatcher("/dishes.jsp").forward(request, response);

        } else if (servletPath.equals("/dishes/create")) {

            getServletContext().getRequestDispatcher("/static/templates/dish-creation.html").forward(request, response);
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        setRequestAndResponseToUTF8(request, response);

        Dish dish = new Dish();
        dish.setName(request.getParameter("name"));
        dish.setPrice(Double.parseDouble(request.getParameter("price")));
        
        dishService.save(dish);

        request.setAttribute("dishes", dishService.findAll());
        
        response.sendRedirect("/Food Delivery Application/dishes");
        // getServletContext().getRequestDispatcher("/dishes.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        dishService.deleteById(Long.parseLong(request.getParameter("id")));

    }

    private void setRequestAndResponseToUTF8(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
    }

}
