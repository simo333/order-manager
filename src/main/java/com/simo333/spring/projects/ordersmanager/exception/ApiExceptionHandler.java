package com.simo333.spring.projects.ordersmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        ApiException apiException = new ApiException(
                e.getMessage(),
                e.getHttpStatus()
        );
        return new ResponseEntity<>(apiException, e.getHttpStatus());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errorsMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> errorsMap.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String exceptionMessage = String.format("The parameter '%s' of value '%s' could not be converted to type '%s'",
                e.getName(), e.getValue(), e.getRequiredType().getSimpleName());
        ApiException apiException = new ApiException(
                exceptionMessage,
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String exceptionMessage = "Invalid request body.";
        ApiException apiException = new ApiException(
                exceptionMessage,
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String exceptionMessage = String.format("Invalid '%s' request method.", e.getMethod());
        ApiException apiException = new ApiException(
                exceptionMessage,
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
