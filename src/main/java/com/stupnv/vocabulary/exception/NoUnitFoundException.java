package com.stupnv.vocabulary.exception;

public class NoUnitFoundException extends RuntimeException {
    public NoUnitFoundException() {
        super("Unable to get/found the unit");
    }
}
