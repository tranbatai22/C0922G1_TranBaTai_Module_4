package com.example.furama_resort.controller.customer;

import com.example.furama_resort.dto.CustomerDto;
import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.service.customer.ICustomerService;
import com.example.furama_resort.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

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

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String saveCus(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes, Model model) {

        Map<String, String> messError = customerService.messError(customerDto);
        new CustomerDto().validate(customerDto, bindingResult);
        model.addAttribute("customerDto",customerDto);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/create";
        }

        if (messError.isEmpty()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Thêm mới khách hàng thành công!");
        } else {
            for (Map.Entry<String, String> error : messError.entrySet()) {
                bindingResult.rejectValue(error.getKey(), error.getValue());
            }
        }

        return "redirect:/customer";
    }
}
