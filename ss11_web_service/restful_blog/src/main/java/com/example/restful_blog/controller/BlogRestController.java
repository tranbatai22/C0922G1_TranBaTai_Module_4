package com.example.restful_blog.controller;

import com.example.restful_blog.model.Blog;
import com.example.restful_blog.service.IBlogService;
import com.example.restful_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> showList(@PageableDefault(size = 2, page = 0)
                                                       Pageable pageable) {
        Page<Blog> blogPage = blogService.findAll(pageable);
        if (blogPage == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogPage, HttpStatus.OK);
        }
    }

    @GetMapping("/byCategory")
    public ResponseEntity<Page<Blog>> findBlogByCategory(@PageableDefault(size = 2, page = 0)
                                                                 Pageable pageable,
                                                         @RequestParam int id) {
        Page<Blog> blogPage = blogService.findBlogByCategory_Id(id, pageable);
        if (blogPage == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogPage, HttpStatus.OK);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> findById(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }
}
