package com.academic.as.demo.controllers.web;

import com.academic.as.demo.models.Department;
import com.academic.as.demo.services.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddDepViewController {

    @Autowired
    SpecializationService specializationService ;

    @GetMapping("/add/department")
    public String addDepView(Model model) {
        model.addAttribute(new Department());
        return "add_dep";
    }

    @PostMapping("/add/department")
    public String addDep(@ModelAttribute("department") @Valid Department department, BindingResult bindingResult , Model model) {
        if (bindingResult.hasErrors()) {
            return "add_dep";
        }
        model.addAttribute("response", specializationService.addDepartment(department));
        return "add_dep";
    }
}