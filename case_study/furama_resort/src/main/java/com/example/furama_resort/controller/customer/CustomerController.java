package com.example.furama_resort.controller.customer;

import com.example.furama_resort.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer")
    public String showList(Model model){
        model.addAttribute("customerList", customerService.findAll());
        return "/customer/list";
    }
}
