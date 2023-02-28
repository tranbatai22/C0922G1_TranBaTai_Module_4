package com.example.nhieu_nhieu.service.impl;

import com.example.nhieu_nhieu.model.Product;
import com.example.nhieu_nhieu.repository.IProductRepository;
import com.example.nhieu_nhieu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
