package com.cibertec.service;

import com.cibertec.dto.LoginRequest;
import com.cibertec.dto.RegisterRequest;

public interface AuthService {

	void register(RegisterRequest request);
    String login(LoginRequest request);
    
}
