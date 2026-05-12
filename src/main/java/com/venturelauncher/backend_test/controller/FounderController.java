package com.venturelauncher.backend_test.controller;

import com.venturelauncher.backend_test.model.Founder;
import com.venturelauncher.backend_test.service.DataStoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/founders")
public class FounderController {
    @Autowired
    private DataStoreService dataStore;

    @PostMapping
    public ResponseEntity<Founder> createFounder(@Valid @RequestBody Founder founder) {
        return new ResponseEntity<>(dataStore.saveFounder(founder), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Founder> getFounders() {
        return dataStore.getAllFounders();
    }
}