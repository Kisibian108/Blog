package com.example.controller;

import com.example.dto.TradeDto;
import com.example.model.Customer;
import com.example.model.Trade;
import com.example.service.ICustomerService;
import com.example.service.ITradeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class TradeCustomer {

    @Autowired
    ITradeService tradeService;

    @Autowired
    ICustomerService customerService;

    @GetMapping("/trade")
    public String showList( @PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> search,Model model){
        String keyword = search.orElse("");
        Page<Trade> tradeList = tradeService.findAllTrade(pageable, keyword);
        model.addAttribute("tradeList",tradeList);
        model.addAttribute("keyword",keyword);
        return "/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("trade", new TradeDto());
        model.addAttribute("customer", customerService.findAll());
        return "/create";
    }

    @PostMapping("/save")
    public String saveCustomer(@Validated @ModelAttribute("trade") TradeDto tradeDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customer", customerService.findAll());
            return "/create";
        } else {
            Trade trade = new Trade();
            BeanUtils.copyProperties(tradeDto, trade);
            tradeService.save(trade);
            redirectAttributes.addFlashAttribute("message",
                    "Create trade: " + tradeDto.getCustomer() + " OK!");
            return "redirect:/trade";
        }
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model, RedirectAttributes redirect) {
        tradeService.delete(id);
        redirect.addFlashAttribute("message", "Removed trade successfully!");
        return "redirect:/trade";
    }

//    @GetMapping("/{id}/view")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("trade", tradeService.findById(id));
//        model.addAttribute("customer", customerService.findAll());
//        return "/view";
//    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        model.addAttribute("trade",tradeService.findByName(name));
        return "/index";
    }

}
