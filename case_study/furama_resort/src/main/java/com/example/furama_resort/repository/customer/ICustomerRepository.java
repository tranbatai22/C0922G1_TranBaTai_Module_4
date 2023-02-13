package com.example.furama_resort.repository.customer;

import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
