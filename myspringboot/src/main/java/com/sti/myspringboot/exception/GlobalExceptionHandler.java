package com.sti.myspringboot.exception;

import com.sti.myspringboot.util.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handlerResponseStatusException(ResponseStatusException e){
        HttpStatus httpCode = HttpStatus.resolve(e.getStatusCode().value());
        String name = httpCode != null ? httpCode.name() : "UNKNOW";
        return ResponseEntity.status(httpCode).body(
                ApiResponse.error(name, e.getReason()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerValidationException(MethodArgumentNotValidException e){
        logger.error("handlerValidationException>>");
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.putIfAbsent(fieldError.getField(), fieldError.getDefaultMessage());
        });
//        String errorMessages = errors.entrySet().stream()
//                                .map(entry -> String.format("%s: %s", entry.getKey(), entry.getValue()))
//                                .collect(Collectors.joining("|"));

        return ResponseEntity.badRequest().body(
                ApiResponse.error(HttpStatus.BAD_REQUEST.name(), errors)
        );
    }

}
