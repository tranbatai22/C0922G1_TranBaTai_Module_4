package com.example.blogging_app2.service.impl;

import com.example.blogging_app2.model.Blog;
import com.example.blogging_app2.repository.IBlogRepository;
import com.example.blogging_app2.service.IBlogService;
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
        return blogRepository.getReferenceById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> search(String title, Pageable pageable) {
        return blogRepository.findByTitleContaining(title, pageable);
    }


}
