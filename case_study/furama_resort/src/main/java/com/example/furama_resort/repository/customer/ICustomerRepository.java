package com.example.furama_resort.repository.customer;

import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where name like :name and email like :email and customer_type_id like :customer_type_id", nativeQuery = true)
    Page<Customer> search(@Param("name") String name, @Param("email") String email, @Param("customer_type_id") String customerTypeId, Pageable pageable);}
