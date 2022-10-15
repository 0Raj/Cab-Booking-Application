package com.thinkify.cabBooking.exceptionHandler;

import com.thinkify.cabBooking.module.ExceptionMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionMsg> generalException(Exception exception, WebRequest request) {

        ExceptionMsg exceptionMsg = new ExceptionMsg(LocalDateTime.now(),
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                "BAD REQUEST",
                request.getDescription(false));

        return new ResponseEntity<ExceptionMsg>(exceptionMsg, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
