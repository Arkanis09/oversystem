package com.boss.oversystem.exception;

public class CategoriaDuplicadaException extends RuntimeException {

    public CategoriaDuplicadaException(Integer id) {

        super("Id duplicado, revisar código o base de datos: " + id);

    }

}
