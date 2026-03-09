package com.example.BaiTap2.Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    @GetMapping("/home")
    @ResponseBody
    public String Index(Principal principal) {
        return "Hello, " + principal.getName();
    }
}
