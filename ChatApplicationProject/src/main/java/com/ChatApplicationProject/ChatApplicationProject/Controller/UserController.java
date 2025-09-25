package com.ChatApplicationProject.ChatApplicationProject.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/dashboard")
    public String userDashboard() {
        return "Welcome to User Dashboard!";
    }
}
