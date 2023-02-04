package com.example.controller;

import com.example.model.Player;
import com.example.service.IManagementPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ManagementPlayer {
    @Autowired
    private IManagementPlayerService iManagementPlayerService;

    @GetMapping("")
    public String showList(Model model) {
        List<Player> playerList = iManagementPlayerService.findAll();
        model.addAttribute("player", playerList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("player", new Player());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Player player, RedirectAttributes redirectAttributes) {
        iManagementPlayerService.save(player);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công.");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("player", iManagementPlayerService.findById(id));
        return "/view";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iManagementPlayerService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Xoa thanh cong.");
        return "redirect:/";
    }
}