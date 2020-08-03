package com.k15t.pat.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException (String message, Throwable cause) {
        super(message, cause);
    }

}
