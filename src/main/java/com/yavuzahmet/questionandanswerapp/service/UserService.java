package com.yavuzahmet.questionandanswerapp.service;

import com.yavuzahmet.questionandanswerapp.converter.UserConverter;
import com.yavuzahmet.questionandanswerapp.dto.UserDto;
import com.yavuzahmet.questionandanswerapp.response.UserResponse;
import com.yavuzahmet.questionandanswerapp.exception.ErrorStatusCode;
import com.yavuzahmet.questionandanswerapp.exception.GeneralException;
import com.yavuzahmet.questionandanswerapp.model.User;
import com.yavuzahmet.questionandanswerapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserConverter userConverter;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userConverter = userConverter;
    }

    public UserResponse createUser(UserDto userDto) {
        var user = userConverter.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userRepository.findUserByUsername(user.getUsername()).isPresent()) {
            throw new GeneralException(ErrorStatusCode.ALREADY_EXIST_USERNAME);
        }
        return userConverter.toResponse(userRepository.save(user));
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new GeneralException(ErrorStatusCode.USER_NOT_FOUND_BY_USERNAME));
    }
}
