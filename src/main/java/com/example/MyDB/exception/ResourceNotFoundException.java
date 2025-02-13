package com.example.MyDB.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 557524696322808421L;
	private String resource;
	public ResourceNotFoundException(String currResource) {
		super(String.format("%s Not Found",currResource));
		this.resource = currResource;
	}
}
