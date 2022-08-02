package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
//@RestController
@CrossOrigin
@RequestMapping("")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    //return Page
    @GetMapping("")
    public String showList(Model model, @PageableDefault(value = 5, sort = "id",direction = Sort.Direction.ASC) Pageable pageable, @RequestParam Optional<String> search) {
        String keyword = search.orElse("");
        Page<Blog> blogList = blogService.getAllBlog(pageable ,keyword);
        model.addAttribute("blogList", blogList);
        return "index";
    }

//    @GetMapping("/list")
//    public ModelAndView getAllBlogPage(Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("index1");
//        modelAndView.addObject("blogList", blogService.getAllBlog());
//        modelAndView.addObject("category", categoryService.getAllCategory());
//        return modelAndView;
//    }

//    @GetMapping
//    public ResponseEntity<Iterable<Blog>> findAllBlog(){
//        List<Blog> blogList =  blogService.getAllBlog();
//        if(blogList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> findAllCategory(){
        Set<Category> categories = (Set<Category>) categoryService.getAllCategory();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //searchbyName
    @GetMapping("/search")
    public ResponseEntity<Iterable<Blog>> searchAllBlog(@RequestParam String keyword){
        List<Blog> blogList =  blogService.searchByName(keyword);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    //searchbyName
    @GetMapping("/searchA")
    public ResponseEntity<Iterable<Blog>> searchAllBlogbyAuthor(@RequestParam String name){
        List<Blog> blogList =  blogService.searchByAuthor(name);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    //get by Id
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    //create
    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id, @RequestBody Blog blog){

        Optional<Blog> currentBlog = blogService.findById(id);
                if(currentBlog == null){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                currentBlog.get().setName(blog.getName());
                blogService.save(currentBlog.get());
                return new ResponseEntity<>(currentBlog.get(), HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable int id) {
        Optional<Blog> blog = blogService.findById(id);
        Category category = categoryService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.delete(id);
        blogService.delete(id);
        return new ResponseEntity<>(blog.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("category",categoryService.getAllCategory());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog,
                                RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message",
                "Create blog: " + blog.getName() + " OK!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect) {
        blogService.delete(blog.getId());
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        model.addAttribute("blog",blogService.searchByName(name));
        return "/index";
    }
}
