package com.example.nhieu_nhieu.service;

import com.example.nhieu_nhieu.model.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustomerService {
    List<Customer> search(String searchCustomerName, String searchProductName);

    List<Customer> findALl();

    void save(Customer customer);

    void delete(int id);
}
