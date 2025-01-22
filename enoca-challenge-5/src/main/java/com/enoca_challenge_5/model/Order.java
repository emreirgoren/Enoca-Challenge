package com.enoca_challenge_5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class Order extends BaseEntity{

    @ManyToOne
    private Cart cart;

}
