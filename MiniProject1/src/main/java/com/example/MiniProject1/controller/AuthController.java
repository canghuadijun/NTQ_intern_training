package com.example.MiniProject1.controller;

import com.example.MiniProject1.models.User;
import com.example.MiniProject1.payload.Request.LoginRequest;
import com.example.MiniProject1.payload.LoginResponse;
import com.example.MiniProject1.payload.RandomStuff;
import com.example.MiniProject1.payload.Request.RegistrationRequest;
import com.example.MiniProject1.payload.Response.AuthenticationResponse;
import com.example.MiniProject1.security.jwt.JwtTokenProvider;
import com.example.MiniProject1.security.services.AuthService;
import com.example.MiniProject1.security.services.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public ResponseEntity<?> testApi() {
        return ResponseEntity.ok().body("Hê lô");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        AuthenticationResponse response = new AuthenticationResponse(token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest) {
        User user = authService.register(registrationRequest);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
