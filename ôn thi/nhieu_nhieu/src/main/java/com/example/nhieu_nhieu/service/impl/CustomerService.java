package com.example.nhieu_nhieu.service.impl;

import com.example.nhieu_nhieu.model.Customer;
import com.example.nhieu_nhieu.repository.ICustomerRepository;
import com.example.nhieu_nhieu.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> search(String searchCustomerName, String searchProductName) {
        return customerRepository.findByCustomerNameAndProductName(searchCustomerName, searchProductName);
    }

    @Override
    public List<Customer> findALl() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
