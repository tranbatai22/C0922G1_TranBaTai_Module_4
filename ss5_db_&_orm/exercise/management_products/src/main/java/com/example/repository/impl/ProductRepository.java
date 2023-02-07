package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
     private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        productList = entityManager.createQuery("select p from Product as p").getResultList();
        return productList;
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Product.class, id));
    }

    @Override
    @Transactional
    public void update(Product product) {
        Product product1 = findById(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setProducer(product.getProducer());
        entityManager.merge(product1);
    }

    @Override
    public List<Product> search(String name) {
        return entityManager.createQuery("select p from Product p where p.name like :name ")
                .setParameter("name",'%'+name+'%').getResultList();
    }
}
