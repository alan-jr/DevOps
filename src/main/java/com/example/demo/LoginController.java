package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, 
                              @RequestParam String password, 
                              Model model) {
        // Simple validation
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            model.addAttribute("message", "Login successful for user: " + username);
            return "success";
        }
        model.addAttribute("error", "Username and password are required!");
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }
}
