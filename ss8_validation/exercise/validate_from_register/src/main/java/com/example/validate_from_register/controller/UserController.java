package com.example.validate_from_register.controller;

import com.example.validate_from_register.dto.UserDto;
import com.example.validate_from_register.model.User;
import com.example.validate_from_register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public String findAll(Model model){
        model.addAttribute("userList", userService.findAll());
        return "/user/list";
    }

    @GetMapping("/user/create")
    public String showFormCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }

    @PostMapping("/user/create")
    public String create(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("userDto", userDto);
            return "/user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess","Them moi thanh cong");
        return "redirect:/user";
    }
}
