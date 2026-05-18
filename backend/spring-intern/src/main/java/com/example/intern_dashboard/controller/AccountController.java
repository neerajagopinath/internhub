package com.example.intern_dashboard.controller;

import com.example.intern_dashboard.dto.request.LoginRequest;
import com.example.intern_dashboard.dto.request.SignupRequest;
import com.example.intern_dashboard.dto.response.ApiResponse;
import com.example.intern_dashboard.service.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AccountController {

    private final AuthService authService;

    public AccountController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signup(
            @RequestBody SignupRequest request
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(
            @RequestBody LoginRequest request
    ) {

        return ResponseEntity
                .ok(authService.login(request));
    }
}