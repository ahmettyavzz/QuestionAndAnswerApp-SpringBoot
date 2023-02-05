package com.yavuzahmet.questionandanswerapp.controller;

import com.yavuzahmet.questionandanswerapp.response.TokenResponse;
import com.yavuzahmet.questionandanswerapp.dto.LoginDto;
import com.yavuzahmet.questionandanswerapp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginDto request){
        return ResponseEntity.ok(authService.login(request));
    }
}
