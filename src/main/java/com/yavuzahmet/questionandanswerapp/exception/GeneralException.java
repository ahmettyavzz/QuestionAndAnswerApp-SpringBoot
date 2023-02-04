package com.yavuzahmet.questionandanswerapp.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class GeneralException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;

    public GeneralException(ErrorStatusCode err) {
        super();
        this.message = err.getDescription();
        this.httpStatus = err.getHttpStatus();
    }
}