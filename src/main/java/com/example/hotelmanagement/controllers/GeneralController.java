package com.example.hotelmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
    @GetMapping("/error")
    public String error() {
        return "error.html";
    }

    @GetMapping ("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping ("/sign-up")
    public String signup() {
        return "sign-up.html";
    }

    @GetMapping("/login?logout=true")
    public String logout(Model model) {
        model.addAttribute("logout", true);
        return "login.html";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile.html";
    }
}

