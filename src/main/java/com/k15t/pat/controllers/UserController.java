package com.k15t.pat.controllers;

import com.k15t.pat.pojos.User;
import com.k15t.pat.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;
    private String message = "";

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register (
            Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String result (@ModelAttribute User user, Model model) {

        // ADD VALIDATION
        User created = userService.save(user);
        message = "Created User " + created.getEmail();
        model.addAttribute("user", created);
        return "redirect:/user?message=" + message;
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String users (
            @RequestParam(name = "message", required = false, defaultValue = "") String message,
            Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        if (!message.isEmpty()) {
            model.addAttribute("msg", message);
        }
        return "user/user";
    }

}
