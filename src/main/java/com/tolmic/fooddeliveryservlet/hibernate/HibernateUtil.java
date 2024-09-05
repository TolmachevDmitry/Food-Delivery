package com.tolmic.fooddeliveryservlet.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.tolmic.fooddeliveryservlet.entities.Dish;
import com.tolmic.fooddeliveryservlet.entities.DishIngredient;
import com.tolmic.fooddeliveryservlet.entities.Ingredient;
import com.tolmic.fooddeliveryservlet.entities.Order;
import com.tolmic.fooddeliveryservlet.entities.User;


@SuppressWarnings("rawtypes")
public class HibernateUtil {
    
    private static SessionFactory sessionFactory = buildSessionFactory(
                                                        Dish.class, 
                                                        Ingredient.class,
                                                        User.class,
                                                        Order.class,
                                                        DishIngredient.class
    );

    private static SessionFactory buildSessionFactory(Class ... classes) {     
        try {
            Configuration configuration = new Configuration().configure();

            for (Class c : classes) {
                configuration.addAnnotatedClass(c);
            }

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

            return sessionFactory;

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
