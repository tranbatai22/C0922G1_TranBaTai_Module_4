package com.example.blogging_app2.controller;

import com.example.blogging_app2.model.Blog;
import com.example.blogging_app2.service.IBlogService;
import com.example.blogging_app2.service.ICategoryService;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/blog")
    public String findAll(Model model, @RequestParam(required = false, defaultValue = "") String searchTitle,
                          @PageableDefault(size = 5, page = 0 , sort = "title", direction = Sort.Direction.ASC)Pageable pageable) {
        Page<Blog> blogPage = blogService.search(searchTitle, pageable);
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("searchTitle",searchTitle);
        return "blog/home";
    }

    @GetMapping("/blog/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        blogService.delete(id);
        model.addAttribute("blogPage", blogService.findAll());
        return "blog/home";
    }

    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/blog/create")
    public String create(Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","Them moi thanh cong");
        return "redirect:/blog";
    }

    @GetMapping("/blog/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/detail";
    }

    @GetMapping("/blog/update/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/update";
    }

}
