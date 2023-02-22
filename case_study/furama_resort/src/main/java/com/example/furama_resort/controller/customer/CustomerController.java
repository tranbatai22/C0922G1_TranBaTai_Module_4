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
import java.util.Objects;
import java.util.Optional;

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
                           @RequestParam(required = false, value = "searchCustomerTypeName", defaultValue = "") String searchCustomerTypeName,
                           @PageableDefault(size = 3) Pageable pageable) {
        Page<Customer> customerPage;
        if(Objects.equals(searchCustomerTypeName, "")){
            customerPage = customerService.search1(searchName,searchEmail,pageable);
        }else {
            customerPage = customerService.search(searchName, searchEmail,searchCustomerTypeName, pageable);
        }
        model.addAttribute("customerPage",customerPage);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchEmail", searchEmail);
        model.addAttribute("searchCustomerTypeName", searchCustomerTypeName);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        Map<String, String> messError = customerService.error(customerDto);
        new CustomerDto().validate(customerDto, bindingResult);
        model.addAttribute("customerDto", customerDto);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/create";
        }

        if (messError.isEmpty()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("mess", "Thêm mới khách hàng thành công");
        }
//        else {
//            for (Map.Entry<String, String> error : messError.entrySet()) {
//                bindingResult.rejectValue(error.getKey(), error.getValue());
//            }
//        }
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customerDto", customerService.findById(id));
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            return "/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/customer";
    }

    @PostMapping(value = "/delete")
    public String deleteCustomer(@ModelAttribute("customer") CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Optional<Customer> customer = customerService.findById(customerDto.getId());
        customer.setDeleted(true);
        boolean check = customerService.editCustomer(customer);
        String mess;
        if (check) {
            mess = "Xóa thành công";
        } else {
            mess = "Đã xảy ra lỗi";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/customer/show-list";
    }
}
