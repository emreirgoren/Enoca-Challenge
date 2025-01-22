package com.enoca_challenge_5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart extends BaseEntity{

    @OneToOne
    private Customer customer;

    @OneToMany
    private List<CartItem> itemList;

    private BigDecimal totalPrice;



}
