package com.foodstore.erp.controller;

import com.foodstore.erp.model.User;
import com.foodstore.erp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute User user) {
        // Set default role for new users
        user.setRole(User.Role.STAFF);
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
    
    @GetMapping("/products")
    public String products() {
        return "products";
    }
    
    @GetMapping("/inventory")
    public String inventory() {
        return "inventory";
    }
    
    @GetMapping("/orders")
    public String orders() {
        return "orders";
    }
    
    @GetMapping("/suppliers")
    public String suppliers() {
        return "suppliers";
    }
    
    @GetMapping("/reports")
    public String reports() {
        return "reports";
    }
}