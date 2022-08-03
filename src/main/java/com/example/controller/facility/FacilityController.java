package com.example.controller.facility;

import com.example.dto.customer.CustomerDto;
import com.example.dto.facility.FacilityDto;
import com.example.model.customer.Customer;
import com.example.model.facility.Facility;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import com.example.service.facility.IFacilityService;
import com.example.service.facility.IFacilityTypeService;
import com.example.service.facility.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    IFacilityService facilityService;

    @Autowired
    IFacilityTypeService facilityTypeService;

    @Autowired
    IRentTypeService rentTypeService;

    @GetMapping("")
    public String showListCustomer( @PageableDefault(value = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam Optional<String> search,Model model) {
        String keyword = search.orElse("");
        Page<Facility> facilityList = facilityService.findAllFacility(pageable, keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("facilityList", facilityList);
        return "facility/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("facility", new FacilityDto());
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/create";
    }

    @PostMapping("/save")
    public String saveCustomer(@Validated @ModelAttribute("facility") FacilityDto facilityDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityType", facilityTypeService.findAll());
            model.addAttribute("rentType", rentTypeService.findAll());
            return "/facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("message",
                    "Create facility: " + facilityDto.getName() + " OK!");
            return "redirect:/facility";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("facility", facilityService.findById(id));
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/edit";
    }

    @PostMapping("/update")
    public String update(Facility facility) {
        facilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model, RedirectAttributes redirect) {
        facilityService.delete(id);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/facility";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", facilityService.findById(id));
        model.addAttribute("customerType", facilityTypeService.findAll());
        return "/facility/view";
    }

}
