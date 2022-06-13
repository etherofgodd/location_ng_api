package com.surge.locationAPI.LocationAPI.advice;

import com.surge.locationAPI.LocationAPI.exceptions.NotFoundException;
import com.surge.locationAPI.LocationAPI.helpers.AppResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppResponse<String>> handleInvalidArgs(MethodArgumentNotValidException ex) {
        var data = new ArrayList<String>();

        ex.getBindingResult().getFieldErrors().forEach(error -> data.add(error.getDefaultMessage()));

        return new ResponseEntity<>(
                new AppResponse<>(
                        false,
                        data,
                        "Invalid Request Body"
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<AppResponse<String>> handleBusinessException(NotFoundException ex) {
        String errorMessage;
        if (ex.getMessage() == null) {
            errorMessage = "Oops! Something happened";
        } else {
            errorMessage = ex.getMessage();
        }

        return new ResponseEntity<>(
                new AppResponse<>(
                        false,
                        null,
                        errorMessage
                ),
                HttpStatus.NOT_FOUND
        );
    }
}
