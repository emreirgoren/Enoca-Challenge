package com.enoca_challenge_5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class CartItem {

    @OneToOne
    private Cart cart;

    @EqualsAndHashCode.Include
    @Column(name = "product")
    private Product product;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

}
