package com.tolmic.fooddeliveryservlet.entities.embeddable;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tolmic.fooddeliveryservlet.entities.Dish;
import com.tolmic.fooddeliveryservlet.entities.User;

import lombok.Data;


@Data
@Embeddable
public class OrderPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, dish);
    }
}
