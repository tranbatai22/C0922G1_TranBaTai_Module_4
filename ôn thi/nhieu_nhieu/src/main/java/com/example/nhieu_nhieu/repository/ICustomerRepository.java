package com.example.nhieu_nhieu.repository;

import com.example.nhieu_nhieu.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select c.* from `customer` c join `customer_product` cp on cp.product_id = c.product_id where c.customer_name like %:searchCustomerName% and cp.product.product_name like %:searchProductName%", nativeQuery = true)
    List<Customer> findByCustomerNameAndProductName(@Param("searchCustomerName")String searchCustomerName, @Param("searchProductName") String searchProductName);
}
