package com.omar.validation.controller;

import com.omar.validation.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showForm(Model mdl){
        User user = new User();
        mdl.addAttribute("user",user);

        //Simulates a database access
        List<String> professions = Arrays.asList("Developer","Architect","Doctor","Nurse");
        mdl.addAttribute("professions", professions);

        return "registracion_form";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute User user, BindingResult binRes, Model mdl){
    //@valid validates our bean (user), and should be always next to BindingResult (which holds the errors)

        if(binRes.hasErrors()){
            List<String> professions = Arrays.asList("Developer","Architect","Doctor","Nurse");
            mdl.addAttribute("professions", professions);

            return "registracion_form";
        }
        else{
            return "register_success";
        }
    }
}
