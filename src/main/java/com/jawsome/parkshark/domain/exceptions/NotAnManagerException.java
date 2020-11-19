package com.jawsome.parkshark.domain.exceptions;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class NotAnManagerException extends RuntimeException {
    public NotAnManagerException(String message) {
        super(message);
    }
}
