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
//		Map<String,String> response = new HashMap<String,String>();
//		String msg = ex.getBind
//		
//		response.put(msg, msg)
		return buildResponse(ex,status);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex,HttpStatus status){
//			String msg = ex.getMessage();
//			String error = HttpStatus.NOT_FOUND.getReasonPhrase();
//			int Status = status.value();
//			ExceptionResponse response = new ExceptionResponse(msg,error,status);
//			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		return buildResponse(ex,status);
	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	ResponseEntity<ExceptionResponse> internalServerError(InternalServerErrorException ex,HttpStatus status){
//		String msg = ex.getMessage();
//		int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
//		String error = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
//		ExceptionResponse response = new ExceptionResponse(msg,error,status);
//		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		return buildResponse(ex,status);
	}
}
