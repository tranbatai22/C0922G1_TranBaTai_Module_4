package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String showform(){
        return "main";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam int num1, @RequestParam int num2,@RequestParam String math, Model model){
        String result = null;
        switch (math){
            case "addition":
                result = String.valueOf(num1 + num2);
                break;
            case "subtraction":
                result = String.valueOf(num1 - num2);
                break;
            case "multiplication":
                result = String.valueOf(num1 * num2);
                break;
            case "division":
                if (num2 == 0){
                    result = "lỗi chia cho 0";
                }else {
                    result = String.valueOf(num1 / num2);
                }
                break;
        }
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        model.addAttribute("result",result);
        return "main";
    }
}