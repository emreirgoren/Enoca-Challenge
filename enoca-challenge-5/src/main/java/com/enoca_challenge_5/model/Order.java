package com.enoca_challenge_5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order")
@Getter
@Setter
public class Order extends BaseEntity{

    @ManyToOne
    private Customer customer;

    @Column(name = "order_price")
    private BigDecimal orderPrice;

    @ManyToOne
    private Cart cart;

    

}
