package com.crudservice.org.exceptions;



import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		ExceptionsRespoce exceptionsRespoce= new ExceptionsRespoce(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionsRespoce,HttpStatus.INTERNAL_SERVER_ERROR);
}

	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleAllUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		ExceptionsRespoce exceptionsRespoce= new ExceptionsRespoce(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionsRespoce,HttpStatus.NOT_FOUND);
}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ExceptionsRespoce exceptionsRespoce= new ExceptionsRespoce(new Date(), "validation failed",ex.getBindingResult().toString());
		return new ResponseEntity<>(exceptionsRespoce,HttpStatus.BAD_REQUEST);
	}
	
}
	