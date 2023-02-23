package com.example.furama_resort.controller.contract;

import com.example.furama_resort.dto.ContractDto;
import com.example.furama_resort.dto.FacilityDto;
import com.example.furama_resort.model.contract.Contract;
import com.example.furama_resort.model.facility.Facility;
import com.example.furama_resort.service.contract.IContractService;
import com.example.furama_resort.service.customer.ICustomerService;
import com.example.furama_resort.service.employee.IEmployeeService;
import com.example.furama_resort.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("contractList", contractService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("facilityList", facilityService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        return "/contract/list";
    }

    @GetMapping("/create")
    public String showFromCreate(Model model){
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("facilityList", facilityService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        return "/contract/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute ContractDto contractDto, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractDto", contractDto);
            return "/contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/contract";
    }
}
