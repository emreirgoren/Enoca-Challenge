package com.enoca_challenge_5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    @OneToOne
    private Cart cart;

    @OneToMany
    private Order order;



}
