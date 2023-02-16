package com.example.restful_blog2.repository;

import com.example.restful_blog2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
