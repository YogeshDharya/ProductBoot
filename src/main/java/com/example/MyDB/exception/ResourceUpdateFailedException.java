package com.example.MyDB.exception;

public class ResourceUpdateFailedException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceUpdateFailedException(String msg) {
		super(msg);
	}
}
