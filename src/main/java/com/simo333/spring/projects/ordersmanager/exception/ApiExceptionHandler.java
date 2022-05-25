package com.simo333.spring.projects.ordersmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        ApiException apiException = new ApiException(
                e.getMessage(),
                e.getHttpStatus(),
                ZonedDateTime.now(ZoneId.systemDefault())
        );
        return new ResponseEntity<>(apiException, e.getHttpStatus());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errorsMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> errorsMap.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
    }

    //Trash version
/*    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(EntityNotFoundException e) {
        ApiException apiException = new ApiException(
                "Nie znaleziono zasobu",
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.systemDefault())
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }*/

}
