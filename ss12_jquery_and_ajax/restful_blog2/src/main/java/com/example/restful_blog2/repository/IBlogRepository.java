package com.example.restful_blog2.repository;

import com.example.restful_blog2.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findBlogByCategory_Id(int id, Pageable pageable);

    Page<Blog> findByNameContaining(String name, Pageable pageable);
}
