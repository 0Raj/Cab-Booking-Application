package com.thinkify.cabBooking.exceptionHandler;

import com.thinkify.cabBooking.exception.*;
import com.thinkify.cabBooking.module.ExceptionMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserAlreadyPresentException.class)
    public ResponseEntity<ExceptionMsg> userAlreadyPresentException(UserAlreadyPresentException exception, WebRequest request) {
        ExceptionMsg errorDetails = new ExceptionMsg(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionMsg> userNotFoundException(UserNotFoundException exception, WebRequest request) {
        ExceptionMsg errorDetails = new ExceptionMsg(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoStrongPasswordException.class)
    public ResponseEntity<ExceptionMsg> noStrongPassword(NoStrongPasswordException exception, WebRequest request) {
        ExceptionMsg errorDetails = new ExceptionMsg(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity<ExceptionMsg> driverNotFound(DriverNotFoundException exception, WebRequest request) {
        ExceptionMsg errorDetails = new ExceptionMsg(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DriverAlreadyPresentException.class)
    public ResponseEntity<ExceptionMsg> driverAlreadyPresent(DriverAlreadyPresentException exception, WebRequest request) {
        ExceptionMsg errorDetails = new ExceptionMsg(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoCabFoundException.class)
    public ResponseEntity<ExceptionMsg> noCabFound(NoCabFoundException exception, WebRequest request) {
        ExceptionMsg errorDetails = new ExceptionMsg(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExceptionMsg> noHandler(NoHandlerFoundException exception, WebRequest request) {
        ExceptionMsg errorDetails = new ExceptionMsg(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionMsg> httpRequestMethodException(HttpRequestMethodNotSupportedException exception,
                                                                   WebRequest request) {

        ExceptionMsg errorDetail = new ExceptionMsg(LocalDateTime.now(), HttpStatus.METHOD_NOT_ALLOWED.value(),
                exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetail, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionMsg> missingServletRequestParameterException(
            MissingServletRequestParameterException exception, WebRequest request) {

        ExceptionMsg errorDetail = new ExceptionMsg(LocalDateTime.now(), HttpStatus.METHOD_NOT_ALLOWED.value(),
                exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetail, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionMsg> myMANVExceptionHandler(MethodArgumentNotValidException exception,WebRequest request) {

        ExceptionMsg errorDetails = new ExceptionMsg(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),exception.getMessage()
                ,request.getDescription(false)
                );

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionMsg> generalException(Exception exception, WebRequest request) {

        ExceptionMsg exceptionMsg = new ExceptionMsg(LocalDateTime.now(),
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionMsg, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
