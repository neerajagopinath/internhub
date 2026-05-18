package com.example.intern_dashboard.service.impl;

import com.example.intern_dashboard.dto.request.LoginRequest;
import com.example.intern_dashboard.dto.request.SignupRequest;
import com.example.intern_dashboard.dto.response.ApiResponse;
import com.example.intern_dashboard.entity.User;
import com.example.intern_dashboard.exception.BadRequestException;
import com.example.intern_dashboard.repository.UserRepository;
import com.example.intern_dashboard.service.AuthService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ApiResponse signup(SignupRequest request) {

        User existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser != null) {
            throw new BadRequestException("Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        userRepository.save(user);

        return new ApiResponse("Signup successful");
    }

    @Override
    public ApiResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            throw new BadRequestException(
                    "Invalid email or password"
            );
        }

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new BadRequestException(
                    "Invalid email or password"
            );
        }

        return new ApiResponse("Login successful");
    }
}