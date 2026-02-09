package com.example.demo.exceptionhandler;

public class AccessDeniedException extends RuntimeException{
    public AccessDeniedException(String message){
        super(message);
    }
}
