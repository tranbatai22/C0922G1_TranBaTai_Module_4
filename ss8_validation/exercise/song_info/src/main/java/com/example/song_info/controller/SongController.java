package com.example.song_info.controller;

import com.example.song_info.model.Song;
import com.example.song_info.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/song")
    public String showList(Model model) {
        model.addAttribute("songList", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String create(Song song, Model model, RedirectAttributes redirectAttributes) {
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/song";
    }
}
