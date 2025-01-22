package com.enoca_challenge_5.converter;

import com.enoca_challenge_5.dto.request.CreateCustomerRequest;
import com.enoca_challenge_5.dto.response.CreateCustomerResponse;
import com.enoca_challenge_5.model.Customer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerConverter {

    public static CreateCustomerResponse toCreateCustomerResponse(Customer customer){

        if(customer == null){
            return null;
        }

        var createCustomerResponse = new CreateCustomerResponse();

        createCustomerResponse.setFirstName(customer.getFirstName());
        createCustomerResponse.setLastName(customer.getLastName());
        createCustomerResponse.setEmail(customer.getEmail());
        createCustomerResponse.setPhone(customer.getPhone());
        createCustomerResponse.setAddress(customer.getAddress());

        return createCustomerResponse;

    }
    public static Customer toCustomer(CreateCustomerRequest createCustomerRequest){

        if(createCustomerRequest == null){
            return null;
        }

        var customer = new Customer();

        customer.setFirstName(createCustomerRequest.getFirstName());
        customer.setLastName(createCustomerRequest.getLastName());
        customer.setEmail(createCustomerRequest.getEmail());
        customer.setPhone(createCustomerRequest.getPhone());
        customer.setAddress(createCustomerRequest.getAddress());

        return customer;

    }

}
