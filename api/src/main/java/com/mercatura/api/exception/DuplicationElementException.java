package com.mercatura.api.exception;

public class DuplicationElementException extends RuntimeException {
    public DuplicationElementException(String class_name){
        super("the " + class_name + " with this informations already exists.");
    }
}
