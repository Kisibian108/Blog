package com.example.controller;

import com.example.dto.SongDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping({"/song", "/home"})
public class SongController {

    @Autowired
    private ISongService songService;

    @RequestMapping("")
    public String showList(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "song";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Song song) {
        songService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Song song) {
        songService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("song") Song song, RedirectAttributes redirect) {
        songService.delete(song.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/song";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/index";
    }
}
