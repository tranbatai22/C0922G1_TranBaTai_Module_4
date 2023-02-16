package com.example.restful_blog2.service.impl;

import com.example.restful_blog2.model.Blog;
import com.example.restful_blog2.repository.IBlogRepository;
import com.example.restful_blog2.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Blog> findBlogByCategory_Id(int id, Pageable pageable) {
        return blogRepository.findBlogByCategory_Id(id, pageable);
    }

}
