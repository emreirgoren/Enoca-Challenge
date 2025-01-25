package com.enoca_challenge_5.controller;

import com.enoca_challenge_5.dto.response.OrderResponse;
import com.enoca_challenge_5.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<OrderResponse> placeOrder(@PathVariable Long customerId){
        return ResponseEntity.ok(orderService.placeOrder(customerId));
    }

    @GetMapping("/ordercode/{orderCode}")
    public ResponseEntity<OrderResponse> getOrderForCode(@PathVariable String orderCode){
        return ResponseEntity.ok(orderService.getOrderForCode(orderCode));
    }

    @GetMapping("/getAllOrdersForCustomer/{customerId}")
    public ResponseEntity<List<OrderResponse>> getAllOrdersForCustomer(@PathVariable Long customerId){
        return ResponseEntity.ok(orderService.getAllOrdersForCustomer(customerId));
    }

}
