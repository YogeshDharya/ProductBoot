package com.example.MyDB.exception;

public class MethodArgumentNotValidException extends RuntimeException{
		public MethodArgumentNotValidException(String msg) {
			super(msg);
		}
}
