package com.example.restful_blog.service.impl;

import com.example.restful_blog.model.Blog;
import com.example.restful_blog.repository.IBlogRepository;
import com.example.restful_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
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
    public void delete(int id) {
        blogRepository.delete(findById(id));
    }

    @Override
    public Page<Blog> search(String title, Pageable pageable) {
        return blogRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public Page<Blog> findBlogByCategory_Id(int id, Pageable pageable) {
        return blogRepository.findBlogByCategory_Id(id,pageable);
    }
}
