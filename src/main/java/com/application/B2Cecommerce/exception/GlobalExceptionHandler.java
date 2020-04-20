package com.application.B2Cecommerce.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.application.B2Cecommerce.model.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {NullPointerException.class, ProdctNotFoundException.class})
	public ResponseEntity<Object> handleInternal(
			RuntimeException ex,  WebRequest request) {

		ErrorMessage error=new ErrorMessage();
		error.setMessage("Product Not found");
		error.setError("Product error");
		error.setStatus(404);
		return new ResponseEntity<Object>("This is Global exception for ecommerce", new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
