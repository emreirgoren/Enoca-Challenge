package com.enoca_challenge_5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "cart")
public class Cart extends BaseEntity{

    @OneToOne
    private Customer customer;

    private BigDecimal totalPrice;



}
