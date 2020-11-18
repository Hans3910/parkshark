package com.jawsome.parkshark.domain.exceptions;

public class MandatoryFieldException extends RuntimeException {
    public MandatoryFieldException(String message) {
        super(message);
    }
}
