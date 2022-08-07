package com.example.controller;

import com.example.dto.QuestionDto;
import com.example.model.Question;
import com.example.model.QuestionType;
import com.example.service.IQuestionService;
import com.example.service.IQuestionTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class QuestionController {

    @Autowired
    IQuestionService questionService;

    @Autowired
    IQuestionTypeService questionTypeService;

    @GetMapping("/question")
    public String showList(@PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> search, Model model){
        String keyword = search.orElse("");
        Page<Question> questions = questionService.findAllQuestion(pageable, keyword);
        model.addAttribute("questions",questions);
        model.addAttribute("keyword",keyword);
        return "/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("question", new QuestionDto());
        model.addAttribute("questionType", questionTypeService.findAll());
        return "/create";
    }

//    @PostMapping("/save")
//    public String saveQuestion(@Validated @ModelAttribute("question") QuestionDto questionDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("questionType", questionTypeService.findAll());
//            return "/create";
//        } else {
//            Question question = new Question();
//            BeanUtils.copyProperties(questionDto, question);
//            questionService.save(question);
//            redirectAttributes.addFlashAttribute("message",
//                    "Create question: " + questionDto.getQuestion() + " OK!");
//            return "redirect:/question";
//        }
//    }

    @PostMapping("/save")
    public String createEmployee(
            @RequestParam("title") String title,
            @RequestParam("question") String question,
            @RequestParam("questionType") QuestionType questionType,

            Model model) {
        model.addAttribute("questionType", questionTypeService.findAll());
        Question question1 = new Question(title,question,questionType);
        questionService.save(question1);
        return "redirect:/question";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("question", questionService.findById(id));
        model.addAttribute("questionType", questionTypeService.findAll());
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Question question, RedirectAttributes redirectAttributes) {
        questionService.save(question);
        redirectAttributes.addFlashAttribute("message","Edit question: " + question.getQuestion() + " OK!" );
        return "redirect:/question";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model, RedirectAttributes redirect) {
        questionService.delete(id);
        redirect.addFlashAttribute("message", "Removed question successfully!");
        return "redirect:/question";
    }

}
