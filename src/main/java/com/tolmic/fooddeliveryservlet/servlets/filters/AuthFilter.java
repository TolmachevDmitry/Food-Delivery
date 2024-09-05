package com.tolmic.fooddeliveryservlet.servlets.filters;

import static java.util.Objects.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tolmic.fooddeliveryservlet.dao.UserDao;
import com.tolmic.fooddeliveryservlet.entities.User;
import com.tolmic.fooddeliveryservlet.entities.enums.Roles;


public class AuthFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain) 
            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<UserDao> userDao = (AtomicReference<UserDao>) req.getServletContext().getAttribute("dao");

        final HttpSession session = req.getSession();

        User user = null;

        System.out.println("AUTH FILTER !");

        if (nonNull(session) && nonNull(session.getAttribute("login")) &&
            nonNull(session.getAttribute("password"))) 
        {

            final Roles role = (Roles) session.getAttribute("role");

            moveToDishes(req, res, role);

        } else if (userDao.get().userIsExist(login, password)) {

            Roles role = userDao.get().getRoleByLoginPassword(login, password);
            
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);

            moveToDishes(req, res, role);

        } else {
            moveToDishes(req, res, null);
        }
        
    }

    private void moveToDishes(final HttpServletRequest req,
                              final HttpServletResponse res,
                              final Roles role)
            throws ServletException, IOException {
        
        switch (role) {
            case CONSUMER -> req.getRequestDispatcher("/sonsumer-menu.jsp").forward(req, res);
            case ADMIN -> req.getRequestDispatcher("/admin-menu.jsp").forward(req, res);
            case COURIER -> req.getRequestDispatcher("/courier-menu.jsp").forward(req, res);
            default -> req.getRequestDispatcher("/login.jsp").forward(req, res);
        }
        
    }

    @Override
    public void destroy() {

    }
}
