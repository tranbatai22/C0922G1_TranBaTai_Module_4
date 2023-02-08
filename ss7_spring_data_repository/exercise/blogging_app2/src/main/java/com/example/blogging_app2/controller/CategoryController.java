package com.example.blogging_app2.controller;

import com.example.blogging_app2.model.Blog;
import com.example.blogging_app2.model.Category;
import com.example.blogging_app2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public String showList(Model model){
        model.addAttribute("categoryList",categoryService.findAll());
        return "category/home";
    }

    @GetMapping("/formCreateCategory")
    public String showFormCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/category/create")
    public String create(Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","Them moi thanh cong");
        return "redirect:/category";
    }

    @GetMapping("/category/update/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/update";
    }

    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        categoryService.delete(id);
        model.addAttribute("categoryList", categoryService.findAll());
        return "category/home";
    }

}
