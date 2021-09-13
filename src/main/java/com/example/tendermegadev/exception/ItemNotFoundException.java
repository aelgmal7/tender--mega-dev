package com.example.tendermegadev.exception;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String message){
        super(message);
    }
}
