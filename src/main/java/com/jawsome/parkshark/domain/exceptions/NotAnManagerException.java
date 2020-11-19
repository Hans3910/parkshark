package com.jawsome.parkshark.domain.exceptions;


public class NotAnManagerException extends RuntimeException {
    public NotAnManagerException(String message) {
        super(message);
    }
}
