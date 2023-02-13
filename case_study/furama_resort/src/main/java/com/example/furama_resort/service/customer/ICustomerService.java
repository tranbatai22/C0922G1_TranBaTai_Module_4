package com.example.furama_resort.service.customer;

import com.example.furama_resort.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);
}
