package com.komal.springbootApp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.komal.springbootApp.custom.exception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException)
	{
		return new ResponseEntity<String>("Input field is empty",HttpStatus.BAD_REQUEST);
		
	}
}
