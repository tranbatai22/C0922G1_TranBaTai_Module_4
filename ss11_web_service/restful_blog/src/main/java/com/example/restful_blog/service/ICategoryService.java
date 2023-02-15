package com.example.restful_blog.service;

import com.example.restful_blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    Optional<Category> findById(int id);

    void save(Category category);

    void delete(int id);
}
