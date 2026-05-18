package com.example.intern_dashboard.service;

import com.example.intern_dashboard.dto.request.LoginRequest;
import com.example.intern_dashboard.dto.request.SignupRequest;
import com.example.intern_dashboard.dto.response.ApiResponse;

public interface AuthService {

    ApiResponse signup(SignupRequest request);

    ApiResponse login(LoginRequest request);
}