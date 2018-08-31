package com.simple_crm.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<CustomerResponseError> exceptionHandler(CustomerNotFoundException e) {
		CustomerResponseError error = new CustomerResponseError(HttpStatus.NOT_FOUND.value(), e.getMessage());

		return new ResponseEntity<CustomerResponseError>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerResponseError> exceptionHandler(Exception e) {
		CustomerResponseError error = new CustomerResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

		return new ResponseEntity<CustomerResponseError>(error, HttpStatus.BAD_REQUEST);
	}
}
