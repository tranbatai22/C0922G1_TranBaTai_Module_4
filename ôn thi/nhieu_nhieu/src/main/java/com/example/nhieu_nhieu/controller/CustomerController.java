package com.example.nhieu_nhieu.controller;

import com.example.nhieu_nhieu.model.Customer;
import com.example.nhieu_nhieu.service.ICustomerService;
import com.example.nhieu_nhieu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false, value = "searchCustomerName", defaultValue = "") String searchCustomerName,
                           @RequestParam(required = false, value = "searchProductName", defaultValue = "") String searchProductName) {
        List<Customer> customerList;
        customerList = customerService.search(searchCustomerName, searchProductName);
        model.addAttribute("customerList", customerList);
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("searchCustomerName", searchCustomerName);
        model.addAttribute("searchProductName", searchProductName);
        return "/list";
    }
}
