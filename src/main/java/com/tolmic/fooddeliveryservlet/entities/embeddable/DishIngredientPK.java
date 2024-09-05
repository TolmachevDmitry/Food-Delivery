package com.tolmic.fooddeliveryservlet.entities.embeddable;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tolmic.fooddeliveryservlet.entities.Dish;
import com.tolmic.fooddeliveryservlet.entities.Ingredient;

import lombok.Data;


@Data
@Embeddable
public class DishIngredientPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dish, ingredient);
    }

}
