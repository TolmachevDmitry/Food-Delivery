package com.tolmic.fooddeliveryservlet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tolmic.fooddeliveryservlet.entities.User;
import com.tolmic.fooddeliveryservlet.services.UserService;

@WebServlet( urlPatterns = { "/my" } )
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");

        if (login == null) {
            getServletContext().getRequestDispatcher("/static/templates/login.html").forward(request, response);
        } else {
            User user = userService.findByLogin(login);
        
            request.setAttribute("orders", user.getOrders());
            
            getServletContext().getRequestDispatcher("/user-menu.jsp").forward(request, response);
        }
    }

}
