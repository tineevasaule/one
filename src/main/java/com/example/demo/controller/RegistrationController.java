package com.example.demo.controller;


import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userSevice;

    @GetMapping("/registr")
    public String registration() {
        return "registr";
    }

    @PostMapping("/registr")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (user.getPassword ()!= null && !user.getPassword().equals(user.getPassword2())) {
            model.addAttribute("passwordError", "Passwords are different!");
        }

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = com.example.demo.controller.ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);

            return "registr";
        }

        if (!userSevice.addUser(user)) {
            model.addAttribute("usernameError", "User exists!");
            return "registr";
        }

        return "redirect:/vhod";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userSevice.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("message", "Activation code is not found!");
        }

        return "vhod";
    }
}