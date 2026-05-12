package com.venturelauncher.backend_test.model;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Founder {
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(regexp = "founder|investor", message = "Role must be 'founder' or 'investor'")
    private String role;

    private List<String> sectors;
    private LocalDateTime createdAt;

    public Founder() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public List<String> getSectors() { return sectors; }
    public void setSectors(List<String> sectors) { this.sectors = sectors; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}