package com.tolmic.fooddeliveryservlet.services;


import com.tolmic.fooddeliveryservlet.dao.UserDao;
import com.tolmic.fooddeliveryservlet.entities.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    public void save(User user) {
        userDao.save(user);
    }

}
