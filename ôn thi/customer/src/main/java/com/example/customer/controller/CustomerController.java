package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.ICustomerService;
import com.example.customer.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(size = 3,page = 0) Pageable pageable,
                           @RequestParam(required = false, value = "searchName", defaultValue = "") String searchName,
                           @RequestParam(required = false, value = "searchEmail", defaultValue = "") String searchEmail) {
        Page<Customer> customerPage;
        customerPage = customerService.findAll(searchName, searchEmail, pageable);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchEmail", searchEmail);
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        return "/list";
    }
}
