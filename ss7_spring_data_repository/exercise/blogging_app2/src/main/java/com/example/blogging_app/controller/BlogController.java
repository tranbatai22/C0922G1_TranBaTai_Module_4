package com.example.blogging_app.controller;

import com.example.blogging_app.model.Blog;
import com.example.blogging_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        blogService.delete(id);
        model.addAttribute("blogList", blogService.findAll());
        return "home";
    }

    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","Them moi thanh cong");
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "update";
    }

}
