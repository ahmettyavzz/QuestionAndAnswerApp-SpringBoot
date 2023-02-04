package com.yavuzahmet.questionandanswerapp.dto;

import com.yavuzahmet.questionandanswerapp.model.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String username;
    private String password;
    private RoleType role;
}