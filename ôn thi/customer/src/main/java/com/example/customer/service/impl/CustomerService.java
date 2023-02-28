package com.example.customer.service.impl;

import com.example.customer.model.Customer;
import com.example.customer.repository.ICustomerRepository;
import com.example.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(String searchName, String searchEmail, Pageable pageable) {
        return customerRepository.findByNameAndEmail(searchName, searchEmail, pageable);
    }
}
