package com.example.furama_resort.service.customer;

import com.example.furama_resort.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
