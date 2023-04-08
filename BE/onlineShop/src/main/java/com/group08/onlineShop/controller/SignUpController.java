package com.group08.onlineShop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/signUp")
public class SignUpController {

    @GetMapping
    public ResponseEntity<String> signUp() {
        return ResponseEntity.ok("SignUp successfully");
    }
}
