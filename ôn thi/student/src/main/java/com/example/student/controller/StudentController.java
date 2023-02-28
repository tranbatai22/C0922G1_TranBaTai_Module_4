package com.example.student.controller;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;
import com.example.student.service.IClazzService;
import com.example.student.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IClazzService clazzService;
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false, value = "searchName", defaultValue = "") String searchName,
                           @RequestParam(required = false, value = "searchClazzName", defaultValue = "") String searchClazzName,
                           @PageableDefault(size = 3, page = 0) Pageable pageable) {
        Page<Student> studentPage;
        studentPage = studentService.search(searchName, searchClazzName, pageable);
        model.addAttribute("studentPage", studentPage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchClazzName", searchClazzName);
        model.addAttribute("clazzList", clazzService.findAll());
        return "/list";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("idDelete") int id, RedirectAttributes redirectAttributes) {
        studentService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "xoá thành công");
        return "redirect:/student";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("studentList", studentService.findAll());
        model.addAttribute("clazzList", clazzService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute StudentDto studentDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("studentDto", studentDto);
            return "/create";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/student";
    }
}
