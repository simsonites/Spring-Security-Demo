package com.softpager.sbsd.demosecurity.controller;

import com.softpager.sbsd.demosecurity.entities.User;
import com.softpager.sbsd.demosecurity.services.TaskService;
import com.softpager.sbsd.demosecurity.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@SuppressWarnings("ALL")
@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

  @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getUsers(Model model, @RequestParam(defaultValue = "") String name){
        List<User> allUsers = userService.getUsers(name);
        log.info("All Users : {} ", allUsers);
        model.addAttribute("users", allUsers);
        return "views/all-users";
    }

    @GetMapping("/profile")
    public String getUser(Principal principal, Model model){
        String email = principal.getName();
        User theUser = userService.getUser(email);
        model.addAttribute("tasks", taskService.findUserTask(theUser));
        model.addAttribute("user", theUser);
        return "views/profile";
    }
}
