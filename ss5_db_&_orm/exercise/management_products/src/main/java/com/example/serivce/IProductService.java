package com.example.serivce;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void delete(int id);
    void update(Product product);
    List<Product> search(String name);
}
