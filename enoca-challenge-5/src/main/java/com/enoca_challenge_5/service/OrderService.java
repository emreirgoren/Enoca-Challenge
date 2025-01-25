package com.enoca_challenge_5.service;

import com.enoca_challenge_5.converter.OrderConverter;
import com.enoca_challenge_5.dto.response.OrderResponse;
import com.enoca_challenge_5.exceptions.BadRequestException;
import com.enoca_challenge_5.exceptions.ExceptionMessageConstants;
import com.enoca_challenge_5.model.Cart;
import com.enoca_challenge_5.model.Customer;
import com.enoca_challenge_5.model.Order;
import com.enoca_challenge_5.repository.CustomerRepository;
import com.enoca_challenge_5.repository.OrderRepository;
import com.enoca_challenge_5.rules.CustomerRules;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    private final CustomerRules customerRules;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    public OrderService(CustomerRules customerRules, CustomerRepository customerRepository, OrderRepository orderRepository, OrderConverter orderConverter) {
        this.customerRules = customerRules;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
    }

    @Transactional
    public OrderResponse placeOrder(Long customerId) {

        customerRules.checkCustomerExistById(customerId);

        Customer customer = customerRepository.findById(customerId).get();

        if(customer.getCart().getItemList().isEmpty()){
            throw new BadRequestException(ExceptionMessageConstants.CART_NULL);
        }

        Order newOrder = new Order();
        newOrder.setCustomer(customer);
        newOrder.setOrderPrice(calculateCartPrice(customer.getCart()));
        newOrder.setCart(customer.getCart());
        newOrder.setOrderCode(createUniqOrderCOde(customerId));
        orderRepository.save(newOrder);
        customer.getCart().getItemList().clear();
        customer.getCart().setTotalPrice(BigDecimal.ZERO);


        return orderConverter.toOrderResponse(newOrder);

    }

    private String createUniqOrderCOde(Long customerId){
        long time = System.currentTimeMillis();
        String uniqCode = customerId.toString() +"-" + time;

        return uniqCode;
    }

    private BigDecimal calculateCartPrice(Cart cart){

        return
                cart.getItemList().stream()
                        .map(item -> item.getPrice())
                        .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

}
