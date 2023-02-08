package com.example.blogging_app2.repository;

import com.example.blogging_app2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
