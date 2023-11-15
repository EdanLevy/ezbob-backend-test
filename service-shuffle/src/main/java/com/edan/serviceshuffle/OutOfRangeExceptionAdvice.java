package com.edan.serviceshuffle;

import com.edan.api.Exceptions.PayloadOutOfRange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OutOfRangeExceptionAdvice {

    @ExceptionHandler(PayloadOutOfRange.class)
    public ResponseEntity<Object> handleException(PayloadOutOfRange e) {
        return new ResponseEntity<>("Payload out of range" + e, null, 400);
    }
}
