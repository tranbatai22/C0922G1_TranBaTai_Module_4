package com.example.song_info.controller;

import com.example.song_info.dto.SongDto;
import com.example.song_info.model.Song;
import com.example.song_info.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/song")
    public String showList(Model model) {
        model.addAttribute("songList", songService.findAll());
        return "song/list";
    }

    //    @GetMapping("/song/create")
//    public String showFormCreate(Model model) {
//        model.addAttribute("songDto", new SongDto());
//        return "song/create";
//    }
//
//    @PostMapping("/song/create")
//    public String create(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult,
//                         Model model, RedirectAttributes redirectAttributes) {
//        new SongDto().validate(songDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("songDto", songDto);
//            return "/song/create";
//        }
//        Song song = new Song();
//        BeanUtils.copyProperties(songDto, song);
//        songService.save(song);
//        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
//        return "redirect:/song";
//    }
    @GetMapping("/song/create")
    public String create(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "/song/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model,
                      RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("songDto", songDto);
            return "/song/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/song";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable int id, Model model){
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(this.songService.findById(id), songDto);
        model.addAttribute("songDto", songDto);
        return "/song/update";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("songDto", songDto);
            return "/song/update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công");
        return "redirect:/song";
    }
}
