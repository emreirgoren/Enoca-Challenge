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
import com.enoca_challenge_5.rules.OrderRules;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final CustomerRules customerRules;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;
    private final OrderRules orderRules;

    public OrderService(CustomerRules customerRules, CustomerRepository customerRepository, OrderRepository orderRepository, OrderConverter orderConverter, OrderRules orderRules) {
        this.customerRules = customerRules;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
        this.orderRules = orderRules;
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

    public OrderResponse getOrderForCode(String orderCode) {
        orderRules.checkOrderIsExist(orderCode);
        return orderConverter.toOrderResponse(orderRepository.findByOrderCode(orderCode));
    }

    public List<OrderResponse> getAllOrdersForCustomer(Long customerId) {

        customerRules.checkCustomerExistById(customerId);

        List<Order> orderList = orderRepository.findAllByCustomerId(customerId);

        return orderList.stream()
                .map(order -> orderConverter.toOrderResponse(order))
                .collect(Collectors.toList());

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
