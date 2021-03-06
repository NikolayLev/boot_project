package ru.levchenko.service.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * utils for field validation
 * used in pages which are used bean validation
 * return map with Errors
 */
public class ControllerUtils {

    static Map<String, String> getErrors(BindingResult bindingResult){

        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() +"Error",
                FieldError::getDefaultMessage
        );
        return bindingResult.getFieldErrors().stream().collect(collector);
    }
}
