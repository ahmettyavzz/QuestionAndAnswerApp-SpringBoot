package com.yavuzahmet.questionandanswerapp.converter;

import com.yavuzahmet.questionandanswerapp.dto.UserDto;
import com.yavuzahmet.questionandanswerapp.response.UserResponse;
import com.yavuzahmet.questionandanswerapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User toEntity(UserDto dto) {
        return new User(dto.getUsername(), dto.getPassword(), dto.getRole());
    }

    public UserResponse toResponse(User entity) {
        return new UserResponse(entity.getUsername());
    }
}