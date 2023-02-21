package com.example.furama_resort.service.customer;

import com.example.furama_resort.dto.CustomerDto;
import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ICustomerService {

    Page<Customer> search(String searchName,String searchEmail,Pageable pageable);

    void save(Customer customer);

    Map<String,String> error(CustomerDto customerDto);
}
