package com.example.blogging_app2.repository;

import com.example.blogging_app2.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    //phân trang list + search
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
}
