package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        if (productList.size() == 0) {
            model.addAttribute("'message", "Empty product list");
        } else {
            model.addAttribute("productList", productList);
        }
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("producers", productService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public ModelAndView save(Product product, RedirectAttributes redirect) {
        if (productService.save(product)) {
            return new ModelAndView("list", "products", productService.findAll());
        } else {
            return new ModelAndView("create", "errorMessage", "Thêm sản phẩm mới không thành công");
        }
    }

    @GetMapping("update/{id}")
    public String update(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("producers", productService.findAll());
        return "update";
    }

    @PostMapping("update")
    public ModelAndView update(Product product) {
        productService.update(product.getId(), product);
        return new ModelAndView("list", "products", productService.findAll());
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam int id) {
        return null;
    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam String name) {
        return null;
    }
}
