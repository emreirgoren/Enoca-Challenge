package com.enoca_challenge_5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "order_price",precision = 20,scale = 4)
    private BigDecimal orderPrice;

}
