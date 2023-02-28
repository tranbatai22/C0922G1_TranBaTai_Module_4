package com.example.nhieu_nhieu.repository;

import com.example.nhieu_nhieu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
