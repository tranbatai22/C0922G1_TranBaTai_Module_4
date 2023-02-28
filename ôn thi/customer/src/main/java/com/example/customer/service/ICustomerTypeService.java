package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
