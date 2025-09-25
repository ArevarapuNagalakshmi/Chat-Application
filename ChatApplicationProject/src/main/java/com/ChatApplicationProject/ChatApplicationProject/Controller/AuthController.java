package com.ChatApplicationProject.ChatApplicationProject.Controller;

import com.ChatApplicationProject.ChatApplicationProject.Dto.LoginRequestDto;
import com.ChatApplicationProject.ChatApplicationProject.Dto.RegisterRequestDto;
import com.ChatApplicationProject.ChatApplicationProject.Entity.Role;
import com.ChatApplicationProject.ChatApplicationProject.Entity.User;
import com.ChatApplicationProject.ChatApplicationProject.Repository.RoleRepository;
import com.ChatApplicationProject.ChatApplicationProject.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final RoleRepository roleRepository;

    @Autowired
    public AuthController(AuthService authService, RoleRepository roleRepository) {
        this.authService = authService;
        this.roleRepository = roleRepository;
    }

    // ------------------ REGISTER ------------------
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequestDto request) {
        // Check password match
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Password and Confirm Password do not match!");
        }

        // Check if email exists
        if (authService.emailExists(request.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use!");
        }

        try {
            User user = authService.register(request);
            return ResponseEntity.ok("User registered successfully with email: " + user.getEmail());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Something went wrong! " + e.getMessage());
        }
    }

    // ------------------ LOGIN ------------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {
        try {
            User user = authService.login(request);

            Set<String> roles = user.getRoles().stream()
                    .map(Role::getName)
                    .collect(Collectors.toSet());

            return ResponseEntity.ok(
                    "Login successful! UserId: " + user.getUserid() + ", Roles: " + roles
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Invalid email or password!");
        }
    }

    // ------------------ CREATE ROLE ------------------
    @PostMapping("/roles/create")
    public ResponseEntity<?> createRole(@RequestBody Role role) {
        if (roleRepository.findByName(role.getName()).isPresent()) {
            return ResponseEntity.badRequest().body("Role already exists: " + role.getName());
        }
        Role savedRole = roleRepository.save(role);
        return ResponseEntity.ok(savedRole);
    }

    // ------------------ GET ALL ROLES ------------------
    @GetMapping("/roles")
    public ResponseEntity<Set<Role>> getRoles() {
        Set<Role> roles = roleRepository.findAll().stream().collect(Collectors.toSet());
        return ResponseEntity.ok(roles);
    }
}

