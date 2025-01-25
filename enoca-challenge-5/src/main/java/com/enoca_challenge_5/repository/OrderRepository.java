package com.enoca_challenge_5.repository;

import com.enoca_challenge_5.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    boolean existsByOrderCode(String orderCode);

    Order findByOrderCode(String orderCode);

    List<Order> findAllByCustomerId(Long customerId);
}
