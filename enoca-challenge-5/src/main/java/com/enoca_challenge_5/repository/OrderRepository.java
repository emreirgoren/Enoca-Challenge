package com.enoca_challenge_5.repository;

import com.enoca_challenge_5.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
