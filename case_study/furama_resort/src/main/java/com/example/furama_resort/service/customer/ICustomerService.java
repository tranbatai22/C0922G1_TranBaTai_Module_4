package com.example.furama_resort.service.customer;

import com.example.furama_resort.dto.CustomerDto;
import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.Optional;

public interface ICustomerService {

    Page<Customer> search(String searchName, String searchEmail, String searchCustomerTypeName, Pageable pageable);

    Page<Customer> search1(String searchName, String searchEmail, Pageable pageable);

    void save(Customer customer);

    Optional<Customer> findById(int id);

    Map<String, String> error(CustomerDto customerDto);

    void delete(int id);
}
