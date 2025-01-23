package com.enoca_challenge_5.converter;

import com.enoca_challenge_5.dto.request.CreateCustomerRequest;
import com.enoca_challenge_5.dto.response.CreateCustomerResponse;
import com.enoca_challenge_5.exceptions.BadRequestException;
import com.enoca_challenge_5.exceptions.ExceptionMessageConstants;
import com.enoca_challenge_5.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {


    public Customer toCustomer(CreateCustomerRequest createCustomerRequest) {

        if(createCustomerRequest == null){
            throw new BadRequestException(ExceptionMessageConstants.REQUEST_NULL);
        }

        Customer customer = new Customer();

        customer.setFirstName(createCustomerRequest.getFirstName());
        customer.setLastName(createCustomerRequest.getLastName());
        customer.setEmail(createCustomerRequest.getEmail());
        customer.setAddress(createCustomerRequest.getAddress());

        return customer;

    }

    public CreateCustomerResponse toCreateCustomerResponse(Customer customer) {

        if(customer == null){
            throw new BadRequestException(ExceptionMessageConstants.CUSTOMER_NULL);
        }

        CreateCustomerResponse createCustomerResponse = new CreateCustomerResponse();

        createCustomerResponse.setFirstName(customer.getFirstName());
        createCustomerResponse.setLastName(customer.getLastName());

        return createCustomerResponse;

    }
}
