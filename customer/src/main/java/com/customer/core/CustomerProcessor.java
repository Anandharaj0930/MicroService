package com.customer.core;

import com.customer.entity.Customer;
import com.customer.exception.CustomerCoreException;
import com.customer.exception.CustomerExternalException;
import com.customer.exception.CustomerGetException;
import com.customer.external.IExternalClient;
import com.customer.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerProcessor implements ICustomerProcessor {

    private ICustomerRepository customerRepository;
    private IBuildOrderCode orderCodeBuilder;
    @Autowired
    private IExternalClient externalClient;

    @Override
    public CustomerResponse createOrder(CustomerRequest customerRequest) {
        CustomerResponse customerResponse = new CustomerResponse();
        Customer customer;
        getStock(customerRequest);
        try {
            customer = buildEntity(customerRequest);
            customerRepository.save(customer);
            customerResponse.setOrderCode(customer.getOrderCode());
            customerResponse.setOrderDescription("Order placed successfully");
        } catch (Exception ex) {
            throw new CustomerCoreException();
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

    public void getStock(CustomerRequest customerRequest) {
        try {
            final String uri = "http://stock-service/stock/get/{name}";
            Map<String, String> params = new HashMap();
            params.put("name", customerRequest.getProductName());
            GetStockResponse stock = (GetStockResponse) externalClient.getMethod(uri, GetStockResponse.class, params);
            if (!"ok".equalsIgnoreCase(stock.getStatusMsg())) {
                throw new CustomerGetException();
            }
        } catch (Exception ex) {
            throw new CustomerExternalException();
        }

    }
}
