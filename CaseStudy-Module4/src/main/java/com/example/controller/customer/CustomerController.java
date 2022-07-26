package com.example.controller.customer;

import com.example.model.customer.Customer;
import com.example.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public String showListCustomer(Model model,@PageableDefault(value = 5,sort = "id", direction = Sort.Direction.ASC) Pageable pageable ){
        Page<Customer> customerList = customerService.findAll(pageable);
        model.addAttribute("customerList", customerList );
        return "customer/index";
    }
}
