package com.jawsome.parkshark.domain.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logException(ex);
        return createResponseEntity("Wrong request", ex.getRequestURL(), HttpStatus.NOT_FOUND);
    }
  private final Logger myLogger = LoggerFactory.getLogger(ExceptionHandlerController.class);
//    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
//        return new ResponseEntity<>(apiError, apiError.getStatus());


//    @ExceptionHandler(NotUniqueArgumentException.class)
//    protected ResponseEntity<Object> handleAdminIdNotFound(
//            NotUniqueArgumentException ex) {
//        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN);
//        apiError.setMessage(ex.getMessage());
//        myLogger.warn(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }

    @ExceptionHandler(MandatoryFieldException.class)
    protected void mandatoryFieldExceptionHandler(MandatoryFieldException exception, HttpServletResponse response) throws IOException {
        logException(exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }
    private void logException(Exception exception) {
        logger.error(exception.getClass().toGenericString());
        logger.error(exception.getMessage());
    }

    public ResponseEntity createResponseEntity(String message, String path, HttpStatus status) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode errorJson = mapper.createObjectNode();
        errorJson.put("message", message);
        errorJson.put("path", path);

        ResponseEntity responseEntity = new ResponseEntity(errorJson, status);
        return responseEntity;
    }
}
