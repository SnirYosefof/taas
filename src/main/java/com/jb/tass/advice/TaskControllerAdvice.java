package com.jb.tass.advice;

import com.jb.tass.dto.ErrDto;
import com.jb.tass.exception.TaskSecurityException;
import com.jb.tass.exception.TaskSystemException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

//Created by sniryosefof on 29 יוני
@RequiredArgsConstructor
public class TaskControllerAdvice {

    @ExceptionHandler(value = {TaskSecurityException.class})
    public ResponseEntity<?> handlerExceptionSecurity(TaskSecurityException e){
    return new ResponseEntity<>(e.getSecMsg().getMsg(),e.getSecMsg().getStatus());
    }

    @ExceptionHandler(value = {TaskSystemException.class})
    public ErrDto handlerException(Exception e){
        return new ErrDto(e.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
