package com.enoca_challenge_5.repository;


import com.enoca_challenge_5.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    Optional<Customer> findByEmail(String email);
}
