package com.example.restful_blog2.service;

import com.example.restful_blog2.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
}
