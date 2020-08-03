package com.k15t.pat.exception;

public class UserIdMissMatchException extends RuntimeException {
    public UserIdMissMatchException (String message, Throwable cause) {
        super(message, cause);
    }
}
