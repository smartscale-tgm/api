package io.swagger.error;

import org.springframework.http.HttpStatus;

public class HttpStatusError extends RuntimeException {

    private HttpStatus code;

    public HttpStatusError(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }
}
