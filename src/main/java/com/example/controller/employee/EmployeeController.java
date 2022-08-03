package com.example.controller.employee;

import com.example.dto.employee.EmployeeDto;
import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.service.employee.*;
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

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IDivisionServie divisionServie;

    @Autowired
    IPositionServie positionServie;

    @Autowired
    IEducationDegreeService educationDegreeService;

    @Autowired
    IUserService userService;

    @GetMapping("")
    public String showListCustomer(Model model, @PageableDefault(value = 5,sort = "id", direction = Sort.Direction.ASC) Pageable pageable ){
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employees", employees );
        return "employee/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("employee", new EmployeeDto());
        model.addAttribute("division",divisionServie.findAll());
        model.addAttribute("position",positionServie.findAll());
        model.addAttribute("education",educationDegreeService.findAll());
        model.addAttribute("user",userService.findAll());
        return "/employee/create";
    }

    @PostMapping("/save")
    public String saveEmployee(@Validated @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("division",divisionServie.findAll());
            model.addAttribute("position",positionServie.findAll());
            model.addAttribute("education",educationDegreeService.findAll());
            model.addAttribute("user",userService.findAll());
            return "/employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message",
                    "Create employee: " + employeeDto.getName() + " OK!");
            return "redirect:/employee";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("division",divisionServie.findAll());
        model.addAttribute("position",positionServie.findAll());
        model.addAttribute("education",educationDegreeService.findAll());
        model.addAttribute("user",userService.findAll());
        return "/employee/edit";
    }

    @PostMapping("/update")
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model, RedirectAttributes redirect) {
        employeeService.delete(id);
        redirect.addFlashAttribute("success", "Removed employee successfully!");
        return "redirect:/employee";
    }

//    @GetMapping("/{id}/delete")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("employee", employeeService.findById(id));
//        model.addAttribute("division",divisionServie.findAll());
//        model.addAttribute("position",positionServie.findAll());
//        model.addAttribute("education",educationDegreeService.findAll());
//        model.addAttribute("user",userService.findAll());
//        return "/employee/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute("customer") Employee employee, RedirectAttributes redirect) {
//        employeeService.delete(employee.getId());
//        redirect.addFlashAttribute("success", "Removed employee successfully!");
//        return "redirect:/employee";
//    }

//    @GetMapping("/{id}/view")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("customer", employeeService.findById(id));
//        model.addAttribute("customerType",educationDegreeService.findAll());
//        return "/customer/view";
//    }
}
