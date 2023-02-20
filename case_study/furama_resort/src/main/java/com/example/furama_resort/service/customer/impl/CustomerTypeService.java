package com.example.furama_resort.service.customer.impl;

import com.example.furama_resort.model.customer.CustomerType;
import com.example.furama_resort.repository.customer.ICustomerTypeRepository;
import com.example.furama_resort.service.customer.ICustomerTypeService;
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
