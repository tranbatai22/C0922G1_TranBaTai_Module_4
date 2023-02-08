package com.example.blogging_app2.service;

import com.example.blogging_app2.model.Blog;
import com.example.blogging_app2.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    List<Category> findAll();

    Optional findById(int id);

    void save(Category category);

    void delete(int id);
}
