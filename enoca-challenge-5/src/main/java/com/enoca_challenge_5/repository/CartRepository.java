package com.enoca_challenge_5.repository;

import com.enoca_challenge_5.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findByCustomerId(Long customerId);
}
