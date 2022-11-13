package com.app.ecommerce.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
@Data
public class ErrorEx extends RuntimeException {

    private HttpStatus httpS;
    private String reason;
    private static final Logger log = LoggerFactory.getLogger(ErrorEx.class);

    public ErrorEx(HttpStatus httpS, String reason) {
        this.reason = reason;
        this.httpS = httpS;
        log.info("Error: " + httpS.toString() + " " + reason);
    }
}

