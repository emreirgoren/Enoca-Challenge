package com.enoca_challenge_5.repository;


import com.enoca_challenge_5.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {

    boolean existsByCustomerId(Long customerId);

    Cart findByCustomerId(Long customerId);
}
