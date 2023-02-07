package com.example.controller;


import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@RequestMapping("product")
@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("productList",productService.findAll());
        return "list";
    }
    @GetMapping("create")
    public String showFormCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }


    @PostMapping("create")
    public String save(@ModelAttribute Product product, Model model){
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("delete")
    public String showFormDelete(@RequestParam int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "delete";
    }
    @PostMapping("delete")
    public String delete(@RequestParam int id){
        productService.remove(id);
        return "redirect:/product";
    }
    @GetMapping("update")
    public String showFormUpdate(@RequestParam int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("update")
    public String update(@RequestParam int id,@ModelAttribute Product product){
        productService.update(product);
        return "redirect:/product";
    }

    @GetMapping("search")
    public String search(@RequestParam String nameFind,Model model){
        model.addAttribute("productList",productService.search(nameFind));
        return "list";
    }
}