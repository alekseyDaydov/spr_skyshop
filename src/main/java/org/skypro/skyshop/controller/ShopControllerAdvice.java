package org.skypro.skyshop.controller;

import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.exception.ShopError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    private final static String CODE_NOT_FOUND = "NOT_FOUND";

    @ExceptionHandler(NoSuchProductException.class)
    ResponseEntity<ShopError> noSuchProduct(NoSuchProductException e) {
        return new ResponseEntity<>(new ShopError(CODE_NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
