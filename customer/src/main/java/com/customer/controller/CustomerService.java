package com.customer.controller;

import com.customer.types.CustomerRequest;
import com.customer.types.CustomerResponse;
import com.customer.types.ICustomerProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerService {

    @Autowired
    private ICustomerProcessor customerProcessor;

    @PostMapping(value = "test/order", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CustomerResponse createOrder(@RequestBody CustomerRequest request) {
        return customerProcessor.createOrder(request);
    }
}
