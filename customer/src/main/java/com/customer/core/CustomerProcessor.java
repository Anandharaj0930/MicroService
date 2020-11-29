package com.customer.core;

import com.customer.entity.Customer;
import com.customer.types.*;
import com.customer.types.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerProcessor implements ICustomerProcessor {

    private ICustomerRepository customerRepository;
    private IBuildOrderCode orderCodeBuilder;

    @Override
    public CustomerResponse createOrder(CustomerRequest customerRequest) {
        CustomerResponse customerResponse = new CustomerResponse();
        Customer customer;
        try {
            customer = buildEntity(customerRequest);
            customerRepository.save(customer);
            customerResponse.setOrderCode(customer.getOrderCode());
            customerResponse.setOrderDescription("Order placed successfully");
        } catch (Exception ex) {
            Error errorResponse = new Error();
            errorResponse.setStatusCode("500");
            errorResponse.setStatusMsg("Not able to order the product");
            customerResponse.setError(errorResponse);
        }

        return customerResponse;
    }

    private Customer buildEntity(CustomerRequest customerRequest) {
        Customer entity = new Customer();
        Adderess adderess = new Adderess();
        entity.setOrderCode(orderCodeBuilder.buildOrderCode());
        entity.setPrize(customerRequest.getPrize());
        entity.setProductName(customerRequest.getProductName());
        Optional.ofNullable(customerRequest.getAddress()).ifPresent(adderess1 -> {
            adderess.setdNo(customerRequest.getAddress().getdNo());
            adderess.setEmail(customerRequest.getAddress().getEmail());
            adderess.setMobNo(customerRequest.getAddress().getMobNo());
            adderess.setStreet(customerRequest.getAddress().getStreet());
        });
        entity.setAddress(adderess);
        return entity;
    }

    @Autowired
    public void setCustomerRepository(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setOrderCodeBuilder(IBuildOrderCode orderCodeBuilder) {
        this.orderCodeBuilder = orderCodeBuilder;
    }
}
