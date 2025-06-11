package com.Project.DealerService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DealerNotFoundException.class)
    public ResponseEntity<String> handleDealerNotFound(DealerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dealer not found: " + ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid data: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
    }
}