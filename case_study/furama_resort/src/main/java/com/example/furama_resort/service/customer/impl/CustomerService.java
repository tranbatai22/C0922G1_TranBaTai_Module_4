package com.example.furama_resort.service.customer.impl;

import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.repository.customer.ICustomerRepository;
import com.example.furama_resort.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
