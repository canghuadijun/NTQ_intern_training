package com.example.MiniProject1.security.services;

import com.example.MiniProject1.models.User;
import com.example.MiniProject1.payload.Request.RegistrationRequest;
import com.example.MiniProject1.repositories.UserRepository;
import com.example.MiniProject1.security.jwt.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenUtil;
    }

    public String login(String username, String password) {
        // Kiểm tra thông tin đăng nhập
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Error Services"));
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            return null; // Thông tin đăng nhập không hợp lệ
        }
        // Tạo mã thông báo JWT
        return jwtTokenProvider.generateToken(CustomUserDetails.build(user));
    }


    public User register(RegistrationRequest registrationRequest) {
        // Kiểm tra username đã tồn tại chưa
        if (userRepository.existsByUsername(registrationRequest.getUsername())) {
            throw new IllegalArgumentException("Username is already taken");
        }
        // Tạo đối tượng User từ thông tin đăng ký
        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setRole(registrationRequest.getRole());
        // Lưu user vào cơ sở dữ liệu
        return userRepository.save(user);
    }
}