package com.example.furama_resort.repository.customer;

import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select c.* from `customer` c join `customer_type` ct on c.customer_type_id = ct.customer_type_id  where c.name like %:searchName% and c.email like %:searchEmail% and ct.customer_type_name = :searchCustomerTypeName" ,nativeQuery = true )
    Page<Customer> search(@Param("searchName") String searchName, @Param("searchEmail") String searchEmail,@Param("searchCustomerTypeName") String searchCustomerTypeName,  Pageable pageable);

    @Query(value = "select * from customer where name like %:searchName% and email like %:searchEmail% " ,nativeQuery = true )
    Page<Customer> search1(@Param("searchName") String searchName, @Param("searchEmail") String searchEmail, Pageable pageable);
}
