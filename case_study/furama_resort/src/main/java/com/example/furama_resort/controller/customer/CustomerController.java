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
    public String showList(Model model, @RequestParam(required = false, defaultValue = "") String searchName,
                           @RequestParam(required = false, defaultValue = "") String searchEmail,
                           @RequestParam(required = false, defaultValue = "") String searchCustomerTypeName,
                           @PageableDefault(size = 5, page = 0, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Customer> customerPage = customerService.search(searchName, searchEmail, searchCustomerTypeName, pageable);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchEmail", searchEmail);
        model.addAttribute("searchCustomerTypeName", searchCustomerTypeName);
        return "/customer/list";
    }
}
