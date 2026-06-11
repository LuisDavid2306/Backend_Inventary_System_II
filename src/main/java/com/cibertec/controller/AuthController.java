package com.cibertec.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.dto.AuthResponse;
import com.cibertec.dto.LoginRequest;
import com.cibertec.dto.RegisterRequest;
import com.cibertec.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return "Usuario registrado";
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {
        String token = authService.login(request);
        return new AuthResponse(token);
    }
}
