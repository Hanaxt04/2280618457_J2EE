package com.example.BaiTap2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String Index(Model model) {
        model.addAttribute("title","Dookki");
        return "index";
    }
}
