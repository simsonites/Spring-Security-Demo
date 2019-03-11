package com.softpager.sbsd.demosecurity.controller;

import com.softpager.sbsd.demosecurity.entities.User;
import com.softpager.sbsd.demosecurity.services.TaskService;
import com.softpager.sbsd.demosecurity.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/user-form")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @GetMapping("/admin-form")
    public String showAdminForm(Model model){
        model.addAttribute("user", new User());
        return "views/admin-registration";
    }

    @PostMapping("/create-user")
    public String createUser(@Valid User theUser, BindingResult br, Model model){
        if (br.hasErrors()){
            return "registration";
        }
        if (userService.userExists(theUser.getEmail())){
            model.addAttribute("exist", true);
            log.info("This is the user : {} ", theUser);
            return "registration";
        }
        userService.createUser(theUser);
        return "redirect:/registration/success";
    }

    @PostMapping("/create-admin")
    public String createAdmin(@Valid User theUser, BindingResult br, Model model){
        if (br.hasErrors()){
            return "views/admin-registration";
        }
        if (userService.userExists(theUser.getEmail())){
            model.addAttribute("exist", true);
            log.info("This is the user : {} ", theUser);
            return "views/admin-registration";
        }

        userService.createAdmin(theUser);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/success")
    public String successPage(){
        return "success";
    }

}
