package com.enoca_challenge_5.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart extends BaseEntity{

    @OneToOne
    private Customer customer;

    private BigDecimal totalPrice;

    @OneToMany
    private List<Order> orderList;



}
