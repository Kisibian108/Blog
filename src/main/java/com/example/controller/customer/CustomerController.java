package com.example.controller.customer;

import com.example.dto.customer.CustomerDto;
import com.example.model.customer.Customer;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String showListCustomer( @PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam Optional<String> search,Model model) {
        String keyword = search.orElse("");
        Page<Customer> customerList = customerService.findAllCus(pageable, keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("customerList", customerList);
        return "customer/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("customerType", customerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String saveCustomer(@Validated @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/create";
        } else {
            Customer customer1 = new Customer();
            BeanUtils.copyProperties(customerDto, customer1);
            customerService.save(customer1);
            redirectAttributes.addFlashAttribute("message",
                    "Create customer: " + customerDto.getName() + " OK!");
            return "redirect:/customer";
        }
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerType", customerTypeService.findAll());
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model, RedirectAttributes redirect) {
        customerService.delete(id);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerType", customerTypeService.findAll());
        return "/customer/view";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam String keyword, Model model) {
//        return "redirect:/customer";
//    }

}
