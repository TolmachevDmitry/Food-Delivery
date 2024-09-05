package com.tolmic.fooddeliveryservlet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tolmic.fooddeliveryservlet.entities.User;
import com.tolmic.fooddeliveryservlet.entities.enums.Roles;
import com.tolmic.fooddeliveryservlet.hibernate.HibernateUtil;


public class UserDao {

    public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        session.save(user);
        trn.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        session.update(user);
        trn.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        session.delete(user);
        trn.commit();
        session.close();
    }

    public void deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        session.createQuery("delete from Dish d where d.id = :id").setParameter("id", id).executeUpdate();
        trn.commit();

        session.close();
    }

    @SuppressWarnings("unchecked")
    private List<User> findAll() {

        List<User> users = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        
        users = session.createQuery("select u from User u").list();

        trn.commit();

        session.close();

        return users;
    }

    @SuppressWarnings("unchecked")
    public User findByLogin(String login) {

        User user = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        
        List<User> users = session.createQuery("select u from User u where u.login = :login").setParameter("login", login).list();
        if (!users.isEmpty()) {
            user = users.get(0);
        }

        trn.commit();

        session.close();

        return user;
    }

    public Roles getRoleByLoginPassword(String login, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        
        Roles role = (Roles) session.createQuery("select u.role from User u where u.login = :login and u.password = :password").setParameter("login", login).setParameter("password", password).list().get(0);

        trn.commit();

        session.close();

        return role;
    }

    public boolean userIsExist(String login, String password) {

        for (User user : findAll()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

}
