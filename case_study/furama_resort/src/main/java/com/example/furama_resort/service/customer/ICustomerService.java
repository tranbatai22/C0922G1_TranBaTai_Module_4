package com.example.furama_resort.service.customer;

import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> search(String name,String email,Pageable pageable);

    void save(Customer customer);
}
