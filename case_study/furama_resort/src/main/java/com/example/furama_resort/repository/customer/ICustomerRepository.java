package com.example.furama_resort.repository.customer;

import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where name like %:searchName% and email like %:searchEmail%", nativeQuery = true)
    Page<Customer> search(@Param("searchName") String searchName, @Param("searchEmail") String searchEmail, Pageable pageable);
}
