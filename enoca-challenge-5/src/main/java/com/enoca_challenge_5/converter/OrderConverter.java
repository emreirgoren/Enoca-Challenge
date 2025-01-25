package com.enoca_challenge_5.converter;

import com.enoca_challenge_5.dto.response.OrderResponse;
import com.enoca_challenge_5.exceptions.BadRequestException;
import com.enoca_challenge_5.exceptions.ExceptionMessageConstants;
import com.enoca_challenge_5.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
    public OrderResponse toOrderResponse(Order order) {

        if (order == null){
            throw new BadRequestException(ExceptionMessageConstants.ORDER_NULL);
        }

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderPrice(order.getOrderPrice());
        orderResponse.setOrderCode(order.getOrderCode());


        return orderResponse;

    }
}
