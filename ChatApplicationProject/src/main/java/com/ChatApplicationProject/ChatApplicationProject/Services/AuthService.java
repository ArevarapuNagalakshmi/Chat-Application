package com.ChatApplicationProject.ChatApplicationProject.Services;

import com.ChatApplicationProject.ChatApplicationProject.Dto.LoginRequestDto;
import com.ChatApplicationProject.ChatApplicationProject.Dto.RegisterRequestDto;
import com.ChatApplicationProject.ChatApplicationProject.Entity.Role;
import com.ChatApplicationProject.ChatApplicationProject.Entity.User;
import com.ChatApplicationProject.ChatApplicationProject.Repository.RoleRepository;
import com.ChatApplicationProject.ChatApplicationProject.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public User register(RegisterRequestDto request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // plain password for now

        Role role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRoles(Set.of(role));

        return userRepository.save(user);
    }

    public User login(LoginRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
