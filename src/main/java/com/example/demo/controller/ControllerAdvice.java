package com.example.demo.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

/**
 * В етом класе ми обрабативаем ошибки из LanguageController если в методе getLanguageById введется id
 * которое не существует !!!!
 */
@RestControllerAdvice
public class ControllerAdvice {

    /**
     * етот метод и ловит ошибку NoSuchElementException !!!
     * @return
     */
    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<BadRequest> noSuchElementException() {
        return new ResponseEntity<>(new BadRequest(), HttpStatus.NOT_FOUND);
    }

    @Data
    public class BadRequest {
        private String name = "bad #id";
    }

}
