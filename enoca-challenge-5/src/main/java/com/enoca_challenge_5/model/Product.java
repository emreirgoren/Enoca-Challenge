package com.enoca_challenge_5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends BaseEntity{

    @Column(name = "product_name")
    private String productName;

    @Column(name="description")
    private String description;

    @Column(name = "product_price")
    private BigDecimal price;

    @Column(name = "product_stock")
    private int stock;


}
