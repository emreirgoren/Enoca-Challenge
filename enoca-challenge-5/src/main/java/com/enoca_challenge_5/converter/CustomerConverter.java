package com.enoca_challenge_5.converter;

import com.enoca_challenge_5.dto.request.CreateCustomerRequest;
import com.enoca_challenge_5.dto.response.CreateCustomerResponse;
import com.enoca_challenge_5.model.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {


    public Customer toCustomer(CreateCustomerRequest createCustomerRequest) {

        if(createCustomerRequest == null){
            throw new IllegalArgumentException("createCustomerRequest.not.null");
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
            throw new IllegalArgumentException("customer.not.null");
        }

        CreateCustomerResponse createCustomerResponse = new CreateCustomerResponse();

        createCustomerResponse.setFirstName(customer.getFirstName());
        createCustomerResponse.setLastName(customer.getLastName());

        return createCustomerResponse;

    }
}
