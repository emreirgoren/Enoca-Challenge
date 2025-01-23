package com.enoca_challenge_5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
@Getter
@Setter
public class Item extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    private BigDecimal price;

}
