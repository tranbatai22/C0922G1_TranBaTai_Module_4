package com.example.customer.service.impl;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerType;
import com.example.customer.repository.ICustomerTypeRepository;
import com.example.customer.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
