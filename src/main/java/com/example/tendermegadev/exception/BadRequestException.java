package com.example.tendermegadev.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String value) {
        super(value);
    }
}
