package com.enoca_challenge_5.rules;

import com.enoca_challenge_5.exceptions.BadRequestException;
import com.enoca_challenge_5.exceptions.ExceptionMessageConstants;
import com.enoca_challenge_5.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderRules {

    private final OrderRepository orderRepository;

    public OrderRules(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void checkOrderIsExist(String orderCode) {
        if(!orderRepository.existsByOrderCode(orderCode)){
            throw new BadRequestException(ExceptionMessageConstants.ORDER_NOT_FOUND);
        }
    }
}
