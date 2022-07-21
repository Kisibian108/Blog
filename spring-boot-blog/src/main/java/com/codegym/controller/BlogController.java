package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showStudentList(){
        return new ModelAndView("blog",
                "blogList", blogService.findAll());
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Blog blog,
                                RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message",
                "Create blog: " + blog.getName() + " OK!");
//        return "forward:/student/list";
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/delete";
    }

//    @PostMapping("/delete")
//    public String delete(@ModelAttribute("song") Blog blog, RedirectAttributes redirect) {
//        blogService.delete(blog.getId());
//        redirect.addFlashAttribute("success", "Removed product successfully!");
//        return "redirect:/song";
//    }

//    @GetMapping("/search")
//    public String search(@RequestParam("kq") String keyword,
//                         Model model){
//        List<Blog> blogList = blogService.findByName(keyword);
//        model.addAttribute("blogList",blogList);
//        return "blog";
//    }
}
