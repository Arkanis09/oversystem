package com.boss.oversystem.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CrudExceptions.class)
    public String handleCrudException(CrudExceptions ex, Model model) {
        model.addAttribute("errorMessage", "error en la operación: " + ex.getMessage());

        return "error";

    }

}
