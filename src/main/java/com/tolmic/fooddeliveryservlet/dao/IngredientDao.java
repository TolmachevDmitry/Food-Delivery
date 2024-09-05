package com.tolmic.fooddeliveryservlet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tolmic.fooddeliveryservlet.entities.Dish;
import com.tolmic.fooddeliveryservlet.entities.Ingredient;
import com.tolmic.fooddeliveryservlet.hibernate.HibernateUtil;

public class IngredientDao {

    public void save(Ingredient ingredient) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        session.save(ingredient);
        trn.commit();
        session.close();
    }

    public void update(Ingredient ingredient) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        session.update(ingredient);
        trn.commit();
        session.close();
    }

    public void delete(Ingredient ingredient) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();
        session.delete(ingredient);
        trn.commit();
        session.close();
    }

    public List<Ingredient> findByDish(Dish dish) {
        List<Ingredient> ingredients = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction trn = session.beginTransaction();

        ingredients = (List<Ingredient>)session.createQuery
        (
            "select i from Ingredients i where i.dish.id = " + dish.getId()
        ).list();

        trn.commit();
        session.close();

        return ingredients;
    }

}
