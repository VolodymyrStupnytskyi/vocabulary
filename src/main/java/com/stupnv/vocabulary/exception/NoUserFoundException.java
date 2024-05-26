package com.stupnv.vocabulary.exception;

public class NoUserFoundException extends RuntimeException {
    public NoUserFoundException() {
        super("Unable to get/found the user");
    }
}
