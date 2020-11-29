package com.customer.types;

import com.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICustomerRepository extends JpaRepository<Customer,Long> {

}
