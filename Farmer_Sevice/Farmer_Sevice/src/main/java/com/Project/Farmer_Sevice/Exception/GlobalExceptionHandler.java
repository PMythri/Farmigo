package com.Project.Farmer_Sevice.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;


@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(FarmerNotFoundException.class)
    public ResponseEntity<String> handleFarmerNotFound(FarmerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Farmer not found: " + ex.getMessage());
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
