package com.yavuzahmet.questionandanswerapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorStatusCode {
    USER_NOT_FOUND_BY_USERNAME("User with this username not found!", HttpStatus.NOT_FOUND),
    USER_NOT_FOUND("User not found!", HttpStatus.NOT_FOUND),
    JWT_NOT_VERIFIED("JWT could not verified!", HttpStatus.BAD_REQUEST),
    ALREADY_EXIST_USERNAME("This username already exist!",HttpStatus.BAD_REQUEST),
    INVALID_QUESTION_ID("Invalid question id!",HttpStatus.BAD_REQUEST);

    private final String description;
    private final HttpStatus httpStatus;
}