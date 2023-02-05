package com.yavuzahmet.questionandanswerapp.service;


import com.yavuzahmet.questionandanswerapp.response.TokenResponse;
import com.yavuzahmet.questionandanswerapp.exception.ErrorStatusCode;
import com.yavuzahmet.questionandanswerapp.exception.GeneralException;
import com.yavuzahmet.questionandanswerapp.dto.LoginDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;

    public AuthService(AuthenticationManager authenticationManager, UserService userService, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    public TokenResponse login(LoginDto loginRequest) {
        try {
            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            return TokenResponse
                    .builder()
                    .accessToken(tokenService.generateToken(auth))
                    .user(userService.findUserByUsername(loginRequest.getUsername()))
                    .build();
        } catch (final BadCredentialsException badCredentialsException) {
            throw new GeneralException(ErrorStatusCode.USER_NOT_FOUND);
        }
    }
}