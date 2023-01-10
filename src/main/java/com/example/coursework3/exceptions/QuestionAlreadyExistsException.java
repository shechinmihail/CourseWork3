package com.example.coursework3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class QuestionAlreadyExistsException extends RuntimeException {
    public QuestionAlreadyExistsException(String message) {
        super(message);
    }
}
