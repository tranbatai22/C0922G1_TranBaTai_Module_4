package com.example.customer.repository;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<CustomerType, Integer> {
    @Query(value = "select c.* from customer c where c.name like %:searchName% and c.email like %:searchEmail%", nativeQuery = true)
    Page<Customer> findByNameAndEmail(@Param("searchName") String searchName, @Param("searchEmail") String searchEmail, Pageable pageable);
}
