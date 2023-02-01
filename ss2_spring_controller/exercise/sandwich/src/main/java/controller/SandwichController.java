package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/select")
    public String showForm(){
        return "main";
    }

    @PostMapping("/select")
    public String spicy(@RequestParam String spice, Model model){
        model.addAttribute("spice",spice);
        return "result";
    }
}