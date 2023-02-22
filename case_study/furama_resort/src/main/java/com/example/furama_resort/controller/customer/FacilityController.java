package com.example.furama_resort.controller.customer;

import com.example.furama_resort.dto.FacilityDto;
import com.example.furama_resort.model.facility.Facility;
import com.example.furama_resort.service.facility.IFacilityService;
import com.example.furama_resort.service.facility.IFacilityTypeService;
import com.example.furama_resort.service.facility.IRentTypeService;
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

import java.util.Objects;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;


    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false, value = "searchName", defaultValue = "") String searchName,
                           @RequestParam(required = false, value = "searchFacilityTypeName", defaultValue = "") String searchFacilityTypeName,
                           @PageableDefault(size = 5) Pageable pageable) {
        Page<Facility> facilityPage;
        if(Objects.equals(searchFacilityTypeName, "")){
            facilityPage = facilityService.search(searchName,pageable);
        }else {
            facilityPage = facilityService.search1(searchName,searchFacilityTypeName, pageable);
        }
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchFacilityTypeName", searchFacilityTypeName);
        return "/facility/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "/facility/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityDto", facilityDto);
            return "/facility/create";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("messCreate", "Thêm mới thành công");
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("facilityDto", facilityService.findById(id));
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "/facility/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityDto", facilityDto);
            return "/facility/edit";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("messEdit", "Chỉnh sửa thành công");
        return "redirect:/facility";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("idDelete") int id, RedirectAttributes redirect) {
        facilityService.delete(id);
        redirect.addFlashAttribute("mess", "Xoá thành công!");
        return "redirect:/facility";
    }

}
