package com.example.customer.service;

import com.example.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(String searchName, String searchEmail, Pageable pageable);
}
