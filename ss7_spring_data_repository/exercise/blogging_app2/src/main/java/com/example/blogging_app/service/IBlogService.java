package com.example.blogging_app.service;

import com.example.blogging_app.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);
}
