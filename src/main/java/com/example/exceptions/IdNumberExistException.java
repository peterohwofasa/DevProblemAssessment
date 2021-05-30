package com.example.exceptions;

public class IdNumberExistException extends RuntimeException{

    private static final String MESSAGE ="ID number exist";

    public IdNumberExistException(){
        super(MESSAGE);
    }

    public IdNumberExistException(String message){
        super(message);
    }
}
