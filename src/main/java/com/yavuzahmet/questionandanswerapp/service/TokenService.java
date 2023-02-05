package com.yavuzahmet.questionandanswerapp.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yavuzahmet.questionandanswerapp.exception.ErrorStatusCode;
import com.yavuzahmet.questionandanswerapp.exception.GeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class TokenService {
    @Value("${jwt-variables.KEY}")
    private String KEY;
    @Value("${jwt-variables.ISSUER}")
    private String ISSUER;
    @Value("${jwt-variables.EXPIRES_ACCESS_TOKEN_MINUTE}")
    private Integer EXPIRES_ACCESS_TOKEN_MINUTE;

    public String generateToken(Authentication auth) {
        String username = ((UserDetails) auth.getPrincipal()).getUsername();
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + (EXPIRES_ACCESS_TOKEN_MINUTE * 60 * 1000)))
                .withIssuer(ISSUER)
                //   .withClaim()
                .sign(Algorithm.HMAC256(KEY.getBytes()));
    }

    public DecodedJWT verifyJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(KEY.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        try {
            return verifier.verify(token);
        } catch (Exception e) {
            throw new GeneralException(ErrorStatusCode.JWT_NOT_VERIFIED);
        }
    }
}