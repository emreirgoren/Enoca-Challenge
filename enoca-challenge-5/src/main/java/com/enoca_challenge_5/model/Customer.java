package com.enoca_challenge_5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Size(min = 10,max = 12)
    @Column(name = "phone")
    private String phone;

    @Column(name = "adress")
    private String address;

    @OneToOne
    private Cart cart;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;

}
