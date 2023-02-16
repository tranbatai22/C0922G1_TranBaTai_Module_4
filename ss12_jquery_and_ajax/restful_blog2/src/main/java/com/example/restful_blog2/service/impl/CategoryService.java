package com.example.restful_blog2.service.impl;

import com.example.restful_blog2.model.Category;
import com.example.restful_blog2.repository.ICategoryRepository;
import com.example.restful_blog2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
