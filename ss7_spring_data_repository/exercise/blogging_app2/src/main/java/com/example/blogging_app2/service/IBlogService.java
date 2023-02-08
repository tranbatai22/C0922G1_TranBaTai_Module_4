package com.example.blogging_app2.service;

import com.example.blogging_app2.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);

    Page<Blog> search(String title, Pageable pageable);
}
