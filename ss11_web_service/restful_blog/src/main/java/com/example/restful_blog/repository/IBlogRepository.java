package com.example.restful_blog.repository;

import com.example.restful_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    //phân trang list + search
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
    Page<Blog>findBlogByCategory_Id(int id,Pageable pageable);
}
