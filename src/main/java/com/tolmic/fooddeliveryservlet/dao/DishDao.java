package com.tolmic.fooddeliveryservlet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tolmic.fooddeliveryservlet.entities.Dish;
import com.tolmic.fooddeliveryservlet.hibernate.HibernateUtil;


public class DishDao {

    public void save(Dish dish) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        session.save(dish);
        trn.commit();
        session.close();
    }

    public void update(Dish dish) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        session.update(dish);
        trn.commit();
        session.close();
    }

    public void delete(Dish dish) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        session.delete(dish);
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
    public List<Dish> findAll() {
        List<Dish> dishes = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();

        dishes = (List<Dish>)session.createQuery("select d from Dish d").list();

        trn.commit();
        session.close();

        return dishes;
    }

}
