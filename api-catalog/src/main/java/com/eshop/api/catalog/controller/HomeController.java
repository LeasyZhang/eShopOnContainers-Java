package com.eshop.api.catalog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("OK");
    }
}
