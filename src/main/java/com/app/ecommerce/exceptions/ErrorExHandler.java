package com.app.ecommerce.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice
class ErrorExHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorExHandler.class);

    @ExceptionHandler(ErrorEx.class)
    public ResponseEntity<ErrorRes> errorHandler(HttpServletRequest req, ErrorEx errorEx) {
        ErrorRes errorRes = new ErrorRes();
        errorRes.setCode(errorEx.getHttpS().value());
        errorRes.setReason(errorEx.getReason());
        errorRes.setPath(req.getRequestURI());

        log.error("Exception: {}", errorRes);
        return new ResponseEntity<>(errorRes, errorEx.getHttpS());

    }

}