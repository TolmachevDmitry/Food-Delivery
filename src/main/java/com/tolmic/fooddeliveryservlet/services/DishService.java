package com.tolmic.fooddeliveryservlet.services;

import java.util.List;

import com.tolmic.fooddeliveryservlet.dao.DishDao;
import com.tolmic.fooddeliveryservlet.entities.Dish;


public class DishService {

    private DishDao dishDao = new DishDao();

    public List<Dish> findAll() {
        return dishDao.findAll();
    }

    public void save(Dish dish) {
        dishDao.save(dish);
    }

    public void deleteById(Long id) {
        dishDao.deleteById(id);
    }

}
