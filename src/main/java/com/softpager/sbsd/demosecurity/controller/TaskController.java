package com.softpager.sbsd.demosecurity.controller;

import com.softpager.sbsd.demosecurity.entities.Task;
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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping()
    public String getTaskForm(Model model, User user, HttpSession httpSession){
        httpSession.setAttribute("email", user.getEmail());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("task", new Task());
        return "views/add-task";
    }

    @PostMapping("create")
    public String create(@Valid Task task, BindingResult br,
                                              HttpSession httpSession ){
        if (br.hasErrors()){
            return "views/add-task";
        }
        String email = (String) httpSession.getAttribute("email");
        taskService.createTask(task, userService.getUser(email));
        return "redirect:/users";
    }

}
