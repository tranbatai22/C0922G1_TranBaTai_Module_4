package com.example.furama_resort.controller.customer;

import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.service.customer.ICustomerService;
import com.example.furama_resort.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public String showList(Model model, @RequestParam(required = false, value = "searchName", defaultValue = "") String searchName,
                           @RequestParam(required = false, value = "searchEmail", defaultValue = "") String searchEmail,
                           @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("customerPage", customerService.search(searchName, searchEmail, pageable));
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchEmail", searchEmail);
        return "/customer/list";
    }
}
