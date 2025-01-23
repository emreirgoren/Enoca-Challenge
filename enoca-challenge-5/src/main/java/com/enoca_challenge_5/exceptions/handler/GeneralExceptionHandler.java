package com.enoca_challenge_5.exceptions.handler;

import com.enoca_challenge_5.dto.response.GenericResponse;
import com.enoca_challenge_5.exceptions.BadRequestException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public GenericResponse handleBadRequestException(BadRequestException badRequestException){
        return GenericResponse.failed(badRequestException.getMessage());
    }



}
