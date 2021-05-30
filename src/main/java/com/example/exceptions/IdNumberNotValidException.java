package com.example.exceptions;

public class IdNumberNotValidException extends RuntimeException{

    private static final String MESSAGE = "id number is not valid";

    public IdNumberNotValidException(){
        super(MESSAGE);
    }


}
