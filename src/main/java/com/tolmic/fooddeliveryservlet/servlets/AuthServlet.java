package com.tolmic.fooddeliveryservlet.servlets;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tolmic.fooddeliveryservlet.entities.User;
import com.tolmic.fooddeliveryservlet.entities.enums.Roles;
import com.tolmic.fooddeliveryservlet.services.UserService;


@WebServlet( urlPatterns = { "/registration" } )
public class AuthServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {

        String login = request.getParameter("login");
        
        if (userService.findByLogin(login) != null) {
            request.setAttribute("error", "Пользователь с логином " + login + " уже существует !");
            response.sendRedirect("/registration.jsp");
        } else {
            User user = new User();
            user.setName(request.getParameter("name"));
            user.setSurname(request.getParameter("Surname"));
            user.setCity(request.getParameter("city"));
            user.setBirthday((Date) request.getAttribute("birthday"));
            user.setLogin(login);
            user.setPassword(request.getParameter("password"));
            user.setRole(Roles.CONSUMER);

            userService.save(user);

            response.sendRedirect("/Food Delivery Application/login.jsp");
        }

    }

}
