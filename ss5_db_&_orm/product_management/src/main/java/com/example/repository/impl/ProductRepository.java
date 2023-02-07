package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        productList = entityManager.createQuery("select p from Product p").getResultList();
        return productList;
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }


    @Transactional
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void remove(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Transactional
    @Override
    public void update(Product product) {
        Product product1 = findById(product.getId());
        product1.setName(product.getName());
        product1.setMaker(product.getMaker());
        product1.setQuantity(product.getQuantity());
        product1.setCost(product.getCost());
        product1.setDescription(product.getDescription());
        entityManager.merge(product1);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = new ArrayList<>();
        List<Product> productList = findAll();
        for (Product pr : productList) {
            if (pr.getName().contains(name)) {
                products.add(pr);
            }
        }
        return products;
    }
}
