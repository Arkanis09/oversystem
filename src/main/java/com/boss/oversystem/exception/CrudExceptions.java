package com.boss.oversystem.exception;

public class CrudExceptions extends RuntimeException {

    public CrudExceptions(String message) {

        super(message);

    }

    public CrudExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
