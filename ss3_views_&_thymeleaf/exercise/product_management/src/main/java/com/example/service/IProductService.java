package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean save(Product product);
    void update(int id, Product product);
    void delete(int id);
    Product findById(int id);
    List<Product> findByName(String name);
}