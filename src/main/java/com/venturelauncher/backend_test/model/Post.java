package com.venturelauncher.backend_test.model;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private String id;

    @NotBlank(message = "founderId is required")
    private String founderId;

    @NotBlank(message = "Content cannot be empty")
    private String content;

    private LocalDateTime createdAt;

    public Post() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getFounderId() { return founderId; }
    public void setFounderId(String founderId) { this.founderId = founderId; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}