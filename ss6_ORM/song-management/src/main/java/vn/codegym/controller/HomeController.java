package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.model.Song;
import vn.codegym.service.ISongService;
import vn.codegym.service.SongServiceImpl;

import java.util.List;

@Controller
public class HomeController {
    ISongService songService = new SongServiceImpl();

    @GetMapping("")
    public String showList(Model model){
        List<Song> songList = songService.findAll();
        model.addAttribute("songList",songList);
        return "list";
    }
}
