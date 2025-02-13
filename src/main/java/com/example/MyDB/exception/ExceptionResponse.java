package com.example.MyDB.exception;

public class ExceptionResponse {
	private String message;
	private Throwable error; 
	private int status;
	public ExceptionResponse(String msg,Throwable err, int status ) {
		this.message = msg;
		this.error = err;
		this.status = status;
	}
	public Throwable getError() {
		return this.error;
	}
	public void setError(Throwable newError) {
		this.error = newError;
	}
	public int getStatus() {
		return this.status;
	}
	public void setStatus(int newStatus) {
		this.status = newStatus;
	}
	public void setMessage(String newMessage) {
		this.message = newMessage;
	}
	public String getMessage() {
		return this.message ;
	}
}
