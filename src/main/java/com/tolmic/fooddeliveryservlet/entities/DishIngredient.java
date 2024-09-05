package com.tolmic.fooddeliveryservlet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tolmic.fooddeliveryservlet.entities.embeddable.DishIngredientPK;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dish_ingredient")
public class DishIngredient {

    @Id
    private DishIngredientPK dishIngredientPK;

    @Column(name = "unit_measurement_value")
    private Double unitMeasurementValue;

}
