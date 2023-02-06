package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Phone", 3000.0, "Apple"));
        productList.add(new Product(2, "Samsung", 2000.0, "SamSung"));
        productList.add(new Product(3, "Nokia", 1000.0, "Nokia"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean save(Product product) {
        boolean isNewProduct = false;
        if (productList.get(product.getId()) == null) {
            isNewProduct = true;
            productList.add(product.getId(), product);
        }
        return isNewProduct;
    }

    @Override
    public void update(int id, Product product) {
        productList.add(id, product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
      return null;
    }
}