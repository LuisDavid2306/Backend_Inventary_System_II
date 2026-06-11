package com.cibertec.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.cibertec.dto.LoginRequest;
import com.cibertec.dto.RegisterRequest;
import com.cibertec.entity.User;
import com.cibertec.repository.UserRepository;
import com.cibertec.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);
    }

    @Override
    public String login(LoginRequest request) {

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        boolean passwordCorrect =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword());

        if (!passwordCorrect) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Credenciales inválidas");
        }

        return jwtService.generateToken(user);
    }
}
