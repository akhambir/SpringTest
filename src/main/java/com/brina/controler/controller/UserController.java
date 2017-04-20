package com.brina.controler.controller;

import com.brina.controler.model.User;
import com.brina.controler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("newUser", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("newUser") User user, Model model){
        User existingUser = userService.findByName(user);
        if (existingUser != null) {
            model.addAttribute("userFromDb", existingUser);
            return "welcome";
        }
        return "error";
    }
}
