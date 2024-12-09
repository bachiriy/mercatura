package com.mercatura.api.exception;

public class ElementNotFoundException extends RuntimeException {
    /**
    * Set <code> element_id </code> to null, if you don't want to include it.
    */
    public ElementNotFoundException(String class_name, Long element_id){
        super("The " + class_name + (element_id == null ? "" : " with Id " + element_id) + " not found.");
    }
}
