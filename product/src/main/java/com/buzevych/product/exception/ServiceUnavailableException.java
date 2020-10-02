package com.buzevych.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason = "Service is unavailable")
public class ServiceUnavailableException extends RuntimeException {
}
