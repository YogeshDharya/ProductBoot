package com.example.MyDB.exception;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalEceptionHandler extends RuntimeException{
	
	public ResponseEntity<ExceptionResponse> buildResponse(Exception ex,HttpStatus status){		
		String msg = ex.getMessage();
		Throwable error = ex.getCause(); 
		int Status = status.value();
		ExceptionResponse response = new ExceptionResponse(msg,error,Status);
			return new ResponseEntity<> (response,status);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex,HttpStatus status){
		return buildResponse(ex,status);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex,HttpStatus status){
		return buildResponse(ex,status);
	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	ResponseEntity<ExceptionResponse> internalServerError(InternalServerErrorException ex,HttpStatus status){
		return buildResponse(ex,status);
	}
}
