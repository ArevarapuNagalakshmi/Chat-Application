package com.ChatApplicationProject.ChatApplicationProject.Dto;

import java.util.Set;

public class JwtResponse {

    private String token;
    private Long userId;
    private Set<String> roles;

    public JwtResponse(String token, Long userId, Set<String> roles) {
        this.token = token;
        this.userId = userId;
        this.roles = roles;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}

