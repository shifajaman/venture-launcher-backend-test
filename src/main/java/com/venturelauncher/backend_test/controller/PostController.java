package com.venturelauncher.backend_test.controller;

import com.venturelauncher.backend_test.model.Post;
import com.venturelauncher.backend_test.service.DataStoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private DataStoreService dataStore;

    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody Post post) {
        if (!dataStore.founderExists(post.getFounderId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "Founder ID does not exist"));
        }
        return new ResponseEntity<>(dataStore.savePost(post), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Post> getPosts(@RequestParam(required = false) String founderId) {
        return dataStore.getPosts(founderId);
    }
}