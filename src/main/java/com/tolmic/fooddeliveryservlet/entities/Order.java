package com.tolmic.fooddeliveryservlet.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tolmic.fooddeliveryservlet.entities.embeddable.OrderPK;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private OrderPK orderPK;

    @Column(name = "delivered")
    private boolean delivered;

    @Column(name = "star_grade")
    private Integer starGrade;

    @Column(name = "date")
    private Date orderDate;

}
