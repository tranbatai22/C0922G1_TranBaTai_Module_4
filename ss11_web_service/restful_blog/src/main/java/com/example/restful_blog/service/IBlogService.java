package com.example.restful_blog.service;

import com.example.restful_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);

    Page<Blog> search(String title, Pageable pageable);

    Page<Blog>findBlogByCategory_Id(int id,Pageable pageable);
}
