package com.enoca_challenge_5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart extends BaseEntity {

    @OneToOne(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
    private Customer customer;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Item> itemList;

    @Column(name = "total_price",precision = 20, scale = 2)
    private BigDecimal totalPrice = BigDecimal.ZERO;

}
