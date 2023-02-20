package com.example.furama_resort.service.customer.impl;

import com.example.furama_resort.dto.CustomerDto;
import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.repository.customer.ICustomerRepository;
import com.example.furama_resort.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> search(String searchName, String searchEmail,Pageable pageable) {
        return customerRepository.search(searchName, searchEmail, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Map<String, String> messError(CustomerDto customerDto) {
        Map<String, String> messError=new HashMap<>();
        for (Customer customer:customerRepository.findAll()) {
            if (customer.getIdCard().equals(customerDto.getIdCard())){
                messError.put("Id Card","Id Card đã tồn tại!!");
            }
            if (customer.getEmail().equals(customerDto.getEmail())){
                messError.put("Email","Email đã tồn tại!!");
            }
            if (customer.getPhoneNumber().equals(customerDto.getPhoneNumber())){
                messError.put("Số điện thoại","Số điện thoại đã tồn tại!!");
            }
        }
        return messError;
    }
}
