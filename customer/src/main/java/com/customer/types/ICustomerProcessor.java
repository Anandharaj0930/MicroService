package com.customer.types;

public interface ICustomerProcessor {
    CustomerResponse createOrder(CustomerRequest customerRequest);
}
