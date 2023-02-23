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
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> search(String searchName, String searchEmail, String searchCustomerTypeName, Pageable pageable) {
        return customerRepository.search(searchName, searchEmail,searchCustomerTypeName, pageable);
    }

    @Override
    public Page<Customer> search1(String searchName, String searchEmail, Pageable pageable) {
        return customerRepository.search1(searchName, searchEmail, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Map<String, String> error(CustomerDto customerDto) {
        Map<String, String> messError = new HashMap<>();
        for (Customer customer : customerRepository.findAll()) {
            if (customer.getIdCard().equals(customerDto.getIdCard())) {
                messError.put("Id Card", "Id Card đã tồn tại!");
            }
            if (customer.getEmail().equals(customerDto.getEmail())) {
                messError.put("Email", "Email đã tồn tại!");
            }
            if (customer.getPhoneNumber().equals(customerDto.getPhoneNumber())) {
                messError.put("Số điện thoại", "Số điện thoại đã tồn tại!");
            }
        }
        return messError;
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
