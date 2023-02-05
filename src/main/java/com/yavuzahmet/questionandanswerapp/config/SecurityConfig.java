package com.yavuzahmet.questionandanswerapp.config;

import com.yavuzahmet.questionandanswerapp.security.JWTFilter;
import com.yavuzahmet.questionandanswerapp.security.JwtAccessDeniedHandler;
import com.yavuzahmet.questionandanswerapp.security.JwtAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private final JWTFilter jwtFilter;
    private final JwtAccessDeniedHandler accessDeniedHandler;
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfig(JWTFilter jwtFilter, JwtAccessDeniedHandler accessDeniedHandler, JwtAuthenticationEntryPoint authenticationEntryPoint) {
        this.jwtFilter = jwtFilter;
        this.accessDeniedHandler = accessDeniedHandler;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    public AuthenticationManager authenticationManager(final AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .headers().frameOptions().disable().and()
                .csrf().disable()
                .cors().and()
                .authorizeRequests(auth -> {
                    auth.antMatchers("/api/admin").hasAuthority("ADMIN");
                    auth.antMatchers(HttpMethod.POST,"/v1/option/**").hasAuthority("ADMIN");
                    auth.antMatchers(HttpMethod.POST,"/v1/question/**").hasAuthority("ADMIN");
                    auth.antMatchers("/api/user").hasAnyAuthority("ADMIN", "USER");
                    auth.anyRequest().authenticated();
                })
                .formLogin().disable()
                .httpBasic().disable()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/api/public", "/user", "/api/auth/login");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*");
            }
        };
    }
}